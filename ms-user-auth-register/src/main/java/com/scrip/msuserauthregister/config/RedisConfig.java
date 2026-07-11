package com.scrip.msuserauthregister.config;

//import tools.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        // Serializador para las Llaves (Strings limpios)
//        template.setKeySerializer(new StringRedisSerializer());
//
//        // 1. Crear el ObjectMapper requerido por la nueva clase
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // 2. Pasamos el objectMapper como argumento al constructor
//        template.setValueSerializer(new GenericJacksonJsonRedisSerializer(objectMapper));
//
//        return template;
//    }
//}