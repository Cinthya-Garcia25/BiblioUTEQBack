package com.scrip.msdevoluciones.controller;

import com.scrip.msdevoluciones.dto.DevolucionDto;
import com.scrip.msdevoluciones.dto.DevolucionRequest;
import com.scrip.msdevoluciones.entity.Devolucion;
import com.scrip.msdevoluciones.service.DevolucionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/devoluciones")
@RequiredArgsConstructor
public class DevolucionesController {

    private final DevolucionService devolucionService;

    @PostMapping
    public ResponseEntity<?> registrarDevolucion(@Valid @RequestBody DevolucionRequest request) {
        try {
            Devolucion devolucion = devolucionService.registrarDevolucion(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(devolucion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error inesperado al registrar la devolución: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<DevolucionDto>> listarDevoluciones(
            @RequestParam(required = false) UUID usuarioId,
            @RequestParam(required = false) UUID libroId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return ResponseEntity.ok(devolucionService.listarDevoluciones(usuarioId, libroId, desde, hasta));
    }
}
