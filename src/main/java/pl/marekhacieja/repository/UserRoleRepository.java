package pl.marekhacieja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.marekhacieja.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}