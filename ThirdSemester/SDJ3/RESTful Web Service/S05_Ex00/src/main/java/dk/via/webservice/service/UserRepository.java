package dk.via.webservice.service;

import dk.via.webservice.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
}