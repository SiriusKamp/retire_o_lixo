package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "pins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private String cidade;

    // Mapeia para geometry(Point, 4326)
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point localizacao;

    // Mapeia para text[]
    @Column(columnDefinition = "text[]")
    private String[] tags;
}
