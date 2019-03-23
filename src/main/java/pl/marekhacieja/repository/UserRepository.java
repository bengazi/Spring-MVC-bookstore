package pl.marekhacieja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marekhacieja.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByPasswordAndUsername(String password, String username);
}