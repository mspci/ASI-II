package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.services.IComposantService;

@RestController
@AllArgsConstructor
@RequestMapping("/composant")
public class ComposantController {
    private final IComposantService composantService;
}
