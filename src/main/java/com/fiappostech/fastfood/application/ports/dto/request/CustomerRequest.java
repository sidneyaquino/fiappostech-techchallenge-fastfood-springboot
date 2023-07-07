package com.fiappostech.fastfood.application.ports.dto.request;

import java.util.UUID;

public record CustomerRequest(UUID customerId, String personalId, String email, String name) {
}