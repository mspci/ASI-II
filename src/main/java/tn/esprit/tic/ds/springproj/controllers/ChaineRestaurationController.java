package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.services.ChaineRestaurationService;

@RestController
@AllArgsConstructor
@RequestMapping("/chaine-restauration")
public class ChaineRestaurationController {
    private final ChaineRestaurationService chaineRestaurationService;
}
