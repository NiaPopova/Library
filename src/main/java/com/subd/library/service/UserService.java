package com.subd.library.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.subd.library.entity.UserEntity;
import com.subd.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity signUp(String email, String password) {
        validateEmail(email);
        String hashedPassword = hashPassword(password);

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRegistrationDate(LocalDate.now());
        return userRepository.save(user);
    }

    private void validateEmail(String email) {
        if (!email.matches(
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    private String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    private String unHashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
}
