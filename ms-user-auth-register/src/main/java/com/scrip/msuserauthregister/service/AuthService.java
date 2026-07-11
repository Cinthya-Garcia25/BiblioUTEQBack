package com.scrip.msuserauthregister.service;

import com.scrip.msuserauthregister.domain.User;
import com.scrip.msuserauthregister.dto.LoginRequest;
import com.scrip.msuserauthregister.dto.UserSessionDto;
import com.scrip.msuserauthregister.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthService {

//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    public String login(LoginRequest request) {
//        // 1. Buscar al usuario por correo
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos"));
//
//        // 2. Verificar que la contraseña coincida con el hash de la BD
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Correo o contraseña incorrectos");
//        }
//
//        // 3. Crear el objeto de sesión que irá a Redis
//        UserSessionDto session = UserSessionDto.builder()
//                .userId(user.getId())
//                .email(user.getEmail())
//                .username(user.getNombreCompleto())
//                .rol(user.getRol())
//                .build();
//
//        // 4. Generar un Token aleatorio seguro
//        String token = "TOKEN-" + UUID.randomUUID().toString();
//
//        // 5. Guardar en Redis: Clave = Token, Valor = Session, Expiración = 15 Minutos
//        redisTemplate.opsForValue().set(
//                token,
//                session,
//                15,
//                TimeUnit.MINUTES
//        );
//
//        // 6. Devolver el token al cliente
//        return token;
//    }
//
//    public void logout(String token) {
//        // Validar que el token no venga vacío
//        if (token == null || token.isBlank()) {
//            throw new RuntimeException("Token inválido");
//        }
//
//        // Borrar la clave directamente de Redis
//        Boolean eliminado = redisTemplate.delete(token);
//
//        if (Boolean.FALSE.equals(eliminado)) {
//            throw new RuntimeException("El token no existía o ya había expirado");
//        }
//    }
}
