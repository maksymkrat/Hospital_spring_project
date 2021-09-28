package ua.krat.hospital_v3.service;

import ua.krat.hospital_v3.model.User;

import java.util.Optional;

public interface UserService {

    public void saveUser(User user);

    public boolean inUserAlreadyPresent(User user);

}
