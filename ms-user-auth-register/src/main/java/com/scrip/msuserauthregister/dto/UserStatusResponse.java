package com.scrip.msuserauthregister.dto;

import com.scrip.msuserauthregister.domain.UserRole;

public record UserStatusResponse(
        String email,
        UserRole rol,
        boolean activo
) {}
