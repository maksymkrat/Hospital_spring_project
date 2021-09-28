package ua.krat.hospital_v3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.krat.hospital_v3.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRole(String role);
}
