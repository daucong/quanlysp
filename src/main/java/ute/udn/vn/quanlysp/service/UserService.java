package ute.udn.vn.quanlysp.service;

import ute.udn.vn.quanlysp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    User saveUser(User user);

    void deleteUser(Long id);

    Optional<User> findUserById(Long id);
}
