package com.scrip.msuserauthregister.dto;

import com.scrip.msuserauthregister.domain.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String nombreCompleto,
        String email,
        UserRole rol,
        LocalDateTime fechaRegistro,
        boolean activo
) {}
