package ua.krat.hospital_v3.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ua.krat.hospital_v3.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class USerRepositoryCustomImpl implements UserRepositoryCustom{

    @Value("${spring.queries.find-all-patients}")
    private String AllPatients;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllPatients() {
        Query query = entityManager.createNativeQuery(AllPatients);
        return query.getResultList();
    }
}
