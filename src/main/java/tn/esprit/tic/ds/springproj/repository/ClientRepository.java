package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tic.ds.springproj.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
