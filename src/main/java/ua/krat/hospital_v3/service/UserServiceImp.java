package ua.krat.hospital_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.krat.hospital_v3.model.Role;
import ua.krat.hospital_v3.model.User;
import ua.krat.hospital_v3.repository.RoleRepository;
import ua.krat.hospital_v3.repository.UserRepository;
import ua.krat.hospital_v3.repository.UserRepositoryCustom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRepositoryCustom userRepositoryCustom;

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }


    @Override
    public boolean inUserAlreadyPresent(User user) {
        return userRepository.existsByEmail(user.getEmail());

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllPatients() {
        return userRepositoryCustom.getAllPatients();
    }
}
