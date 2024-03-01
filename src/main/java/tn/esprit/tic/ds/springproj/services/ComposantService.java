package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.repository.ComposantRepository;

@Service
@AllArgsConstructor
public class ComposantService implements IComposantService {
    private final ComposantRepository composantRepository;
}
