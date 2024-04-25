package com.example.phoenixlabtest.service.registration;

import com.example.phoenixlabtest.appuser.AppUserRole;
import com.example.phoenixlabtest.appuser.BasicUser;
import com.example.phoenixlabtest.appuser.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicRegistrationService implements RegistrationService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public void register(BasicUser basicUser) {

        basicUser.setUserRole(AppUserRole.USER);

        String encodedPassword = bCryptPasswordEncoder.encode(basicUser.getPassword());
        basicUser.setPassword(encodedPassword);

        userRepository.save(basicUser);
    }
}
