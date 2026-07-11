package com.scrip.msuserauthregister.service;

import com.scrip.msuserauthregister.domain.User;
import com.scrip.msuserauthregister.dto.RegisterRequest;
import com.scrip.msuserauthregister.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void registerUser(RegisterRequest request) {
        // 1. Validar unicidad del email
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        // 2. Construir la entidad cifrando la contraseña
        User user = User.builder()
                .nombreCompleto(request.getNombreCompleto())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Aquí se aplica BCrypt
                .rol(request.getRol())
                .build();

        // 3. Guardar en Postgres
        userRepository.save(user);
    }
}
