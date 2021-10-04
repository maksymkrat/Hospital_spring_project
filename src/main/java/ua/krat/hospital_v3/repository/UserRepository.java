package ua.krat.hospital_v3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.krat.hospital_v3.model.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByEmail(String email);

    @Override
    List<User> findAll();

//    List<User> findAllPatients();



}
