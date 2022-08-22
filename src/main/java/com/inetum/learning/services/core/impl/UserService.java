package com.inetum.learning.services.core.impl;

import com.inetum.learning.auth.AuthGroup;
import com.inetum.learning.auth.AuthGroupRepository;
import com.inetum.learning.auth.User;
import com.inetum.learning.auth.UserRepository;
import com.inetum.learning.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;
    public void createUser(UserDto userDto) throws IllegalStateException {

        if (null != userRepository.findByUsername(userDto.getUsername())) {
            throw new IllegalStateException("Il existe déjà un utilisateur avec le nom " + userDto.getUsername());
        } else if (null != userRepository.findByEmail(userDto.getEmail())) {
            throw new IllegalStateException("Il y a déjà un utilisateur avec l'email " + userDto.getEmail());
        }
        String username = userDto.getUsername();
        String password = new BCryptPasswordEncoder(11).encode(userDto.getPassword());
        String prenom = userDto.getPrenom();
        String nom = userDto.getNom();
        String email = userDto.getEmail();
        log.info("Getting image");
        log.info("about to upload");
        String imgurl = userDto.getImgurl();
        LocalDate fecha = LocalDate.now();
        User user = new User(username, password, prenom, nom, email, imgurl, fecha);
        AuthGroup group = new AuthGroup();

        group.setUsername(userDto.getUsername());
        group.setAuthgroup("USER");

        userRepository.save(user);
        authGroupRepository.save(group);
    }

    public void update(User user) {
        User current = userRepository.findByUsername(user.getUsername());

        current.setPrenom(user.getPrenom());
        current.setNom(user.getNom());
        current.setEmail(user.getEmail());
        current.setImgurl(user.getImgurl());

        userRepository.save(current);
    }

    public void patch(User user) {
        User current = userRepository.findByUsername(user.getUsername());

        current.setDetail(user.getDetail());

        userRepository.save(current);
    }
}
