package com.example.phoenixlabtest.dto.item;

import java.math.BigInteger;

public record AddItemRequest(BigInteger price, Integer amount, String title, String description) {
}
