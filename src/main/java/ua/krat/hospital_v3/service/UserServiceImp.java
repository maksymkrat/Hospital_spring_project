package ua.krat.hospital_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.krat.hospital_v3.model.Role;
import ua.krat.hospital_v3.model.User;
import ua.krat.hospital_v3.repository.RoleRepository;
import ua.krat.hospital_v3.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

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
}
