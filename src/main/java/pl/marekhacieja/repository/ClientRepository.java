package pl.marekhacieja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marekhacieja.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByPasswordAndUsername(String password, String username);
}