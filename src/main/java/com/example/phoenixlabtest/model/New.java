package com.example.phoenixlabtest.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class New {

    @Id
    @SequenceGenerator(
            name = "new_sequence",
            sequenceName = "new_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "new_sequence"
    )
    private Long id;

    private String header;
    private String text;
    private LocalDateTime createdAt;

    public New(String header, String text, LocalDateTime createdAt) {
        this.header = header;
        this.text = text;
        this.createdAt = createdAt;
    }
}
