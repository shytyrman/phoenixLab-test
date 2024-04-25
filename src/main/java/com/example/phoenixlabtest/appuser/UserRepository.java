package com.example.phoenixlabtest.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<BasicUser, Long> {

    public Optional<BasicUser> findBasicUserByLogin(String login);
    public Boolean existsBasicUserByLogin(String login);
}
