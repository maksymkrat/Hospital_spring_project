package ua.krat.hospital_v3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.krat.hospital_v3.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByEmail(String email);
}
