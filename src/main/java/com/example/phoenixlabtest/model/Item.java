package com.example.phoenixlabtest.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    public Long id;

    public BigInteger price;
    public Integer amount;
    public String title;
    public String description;

    public Item(BigInteger price, Integer amount, String title, String description) {
        this.price = price;
        this.amount = amount;
        this.title = title;
        this.description = description;
    }
}
