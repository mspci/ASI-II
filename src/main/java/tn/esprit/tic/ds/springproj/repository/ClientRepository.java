package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
