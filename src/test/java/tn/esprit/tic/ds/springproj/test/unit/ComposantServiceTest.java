package tn.esprit.tic.ds.springproj.test.unit;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tn.esprit.tic.ds.springproj.entities.Composant;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ComposantRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;
import tn.esprit.tic.ds.springproj.services.ComposantService;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ComposantServiceTest {

    @Mock
    private MenuRepository menuRepository;

    @Mock
    private ComposantRepository composantRepository;

    @InjectMocks
    private ComposantService composantService;

    @Test
//    @Transactional
//    @Rollback
    public void testAjoutComposantsEtMiseAjourPrixMenu_ValidMenu() {
        // Create a sample menu and set of components
        Long menuId = 1L;
        Menu existingMenu = new Menu();
        existingMenu.setIdMenu(menuId);

        Set<Composant> composants = new HashSet<>();
        composants.add(new Composant(1L, "Composant A", 5f, null, null));
        composants.add(new Composant(2L, "Composant B", 10f, null, null));

        // Mock behavior of menuRepository and composantRepository
        when(menuRepository.findById(menuId)).thenReturn(Optional.of(existingMenu));

        // Invoke the service method
        Menu updatedMenu = composantService.ajoutComposantsEtMiseAjourPrixMenu(composants, menuId);

        // Assertions
        assertNotNull(updatedMenu);
        assertEquals(menuId, updatedMenu.getIdMenu());
        assertEquals(15f, updatedMenu.getPrixTotal());
    }

    @Test
//    @Transactional
//    @Rollback
    public void testAjoutComposantsEtMiseAjourPrixMenu_MenuNotFound() {
        // Create a menuId that does not exist in repository
        Long menuId = 999L;
        Set<Composant> composants = new HashSet<>();
        composants.add(new Composant(2L, "Composant C", 8f, null, null));

        // Mock behavior of menuRepository
        when(menuRepository.findById(menuId)).thenReturn(Optional.empty());

        // Invoke the service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> {
            composantService.ajoutComposantsEtMiseAjourPrixMenu(composants, menuId);
        });
    }

    @Test
//    @Transactional
//    @Rollback
    public void testAjoutComposantsEtMiseAjourPrixMenu_PriceExceedsLimit() {
        // Create a sample menu and set of components where total price exceeds limit
        Long menuId = 2L;
        Menu existingMenu = new Menu();
        existingMenu.setIdMenu(menuId);

        Set<Composant> composants = new HashSet<>();
        composants.add(new Composant(4L, "Composant D", 25f, null, null)); // Total price exceeds 20f

        // Mock behavior of menuRepository
        when(menuRepository.findById(menuId)).thenReturn(Optional.of(existingMenu));

        // Invoke the service method and expect an exception
        assertThrows(RuntimeException.class, () -> {
            composantService.ajoutComposantsEtMiseAjourPrixMenu(composants, menuId);
        });
    }
}
