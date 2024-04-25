package com.example.phoenixlabtest.appuser;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class BasicUser {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String avatarLink;
    @Enumerated(EnumType.STRING)
    private AppUserRole userRole;

    public BasicUser(String login, String password, String name, String surname, String avatarLink) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.avatarLink = avatarLink;
    }
}
