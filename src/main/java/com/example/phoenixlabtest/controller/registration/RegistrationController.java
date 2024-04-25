package com.example.phoenixlabtest.controller.registration;

import com.example.phoenixlabtest.appuser.BasicUser;
import com.example.phoenixlabtest.appuser.UserRepository;
import com.example.phoenixlabtest.dto.registration.RegistrationRequest;
import com.example.phoenixlabtest.service.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private final UserRepository userRepository;
    private final RegistrationService registrationService;
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {

        BasicUser basicUser = new BasicUser();

        try {
            if (userRepository.existsBasicUserByLogin(registrationRequest.login())) {
                throw new IllegalArgumentException("User with this username already exists!");
            }
            if (!registrationRequest.password().equals(registrationRequest.checkPassword())) {
                throw new IllegalStateException("Given passwords are different, try again!");
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

        basicUser.setLogin(registrationRequest.login());
        basicUser.setPassword(registrationRequest.password());
        basicUser.setName(registrationRequest.name());
        basicUser.setSurname(registrationRequest.surname());
        basicUser.setAvatarLink(registrationRequest.avatarLink());

        registrationService.register(basicUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(basicUser);
    }
}
