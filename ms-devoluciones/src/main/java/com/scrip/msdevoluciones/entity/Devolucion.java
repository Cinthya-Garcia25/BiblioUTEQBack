package com.scrip.msdevoluciones.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "devoluciones", schema = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Devolucion {

    @Id
    @GeneratedValue
    private UUID id;

    // Relación Uno a Uno con Préstamo debido a la restricción UNIQUE en la base de datos (consultar el objeto en el ms-prestamos con OpenFeign)
    private UUID prestamo;

    @Builder.Default
    @Column(name = "fecha_devolucion", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT now()")
    private OffsetDateTime fechaDevolucion = OffsetDateTime.now();

    @Builder.Default
    @Column(nullable = false)
    private Boolean tardia = false;

    @Builder.Default
    @Column(name = "dias_retraso", nullable = false)
    private Integer diasRetraso = 0;
}