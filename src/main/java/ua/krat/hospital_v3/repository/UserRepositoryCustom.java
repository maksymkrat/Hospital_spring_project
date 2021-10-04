package ua.krat.hospital_v3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.krat.hospital_v3.model.User;

import java.util.List;


public interface UserRepositoryCustom {

    @Query("from User where roles = 'USER'")
    List<User> getAllPatients();
}
