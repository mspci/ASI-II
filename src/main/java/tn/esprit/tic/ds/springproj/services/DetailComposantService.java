package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.repository.DetailComposantRepository;

@Service
@AllArgsConstructor
public class DetailComposantService implements IDetailComposantService {
    private final DetailComposantRepository detailComposantRepository;
}
