package com.example.phoenixlabtest.dto.registration;

public record RegistrationRequest(String login, String password, String checkPassword, String name, String surname,
                                  String avatarLink) {

}
