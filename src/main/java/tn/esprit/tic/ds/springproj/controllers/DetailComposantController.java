package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.services.IDetailComposantService;

@RestController
@AllArgsConstructor
@RequestMapping("/detailComposant")
public class DetailComposantController {
    private final IDetailComposantService detailComposantService;
}
