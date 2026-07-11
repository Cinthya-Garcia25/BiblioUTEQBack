package com.scrip.msuserauthregister.controller;

import com.scrip.msuserauthregister.dto.LoginRequest;
import com.scrip.msuserauthregister.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
//        try {
//            String token = service.login(request);
//            return ResponseEntity.ok(Map.of("token", token));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", e.getMessage()));
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@RequestHeader("Authorization") String bearerToken) {
//        try {
//            // El header suele venir como "Bearer TOKEN-xxxx...". Limpiamos el prefijo si existe:
//            String token = bearerToken;
//            if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//                token = bearerToken.substring(7);
//            }
//
//            service.logout(token);
//            return ResponseEntity.ok(Map.of("message", "Sesión cerrada exitosamente"));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", e.getMessage()));
//        }
//    }
}
