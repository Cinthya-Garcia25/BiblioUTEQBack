package com.scrip.msdevoluciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevolucionDto {
    private UUID id;
    private UUID prestamoId;
    private UUID usuarioId;
    private UUID libroId;
    private OffsetDateTime fechaDevolucion;
    private Boolean tardia;
    private Integer diasRetraso;
}
