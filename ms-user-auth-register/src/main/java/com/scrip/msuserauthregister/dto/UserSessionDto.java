package com.scrip.msuserauthregister.dto;

import com.scrip.msuserauthregister.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDto {
    private UUID userId;
    private String username;
    private String email;
    private UserRole rol;
}
