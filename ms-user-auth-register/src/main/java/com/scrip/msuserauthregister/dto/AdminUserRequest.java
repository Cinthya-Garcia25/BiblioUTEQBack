package com.scrip.msuserauthregister.dto;

import com.scrip.msuserauthregister.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AdminUserRequest(
        @NotBlank @Size(max = 150) String nombreCompleto,
        @NotBlank @Email @Size(max = 150) String email,
        @Size(min = 8, max = 100) String password,
        @NotNull UserRole rol
) {}
