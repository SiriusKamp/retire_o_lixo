package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List; // ← IMPORT ESSENCIAL

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

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @ElementCollection
    private List<String> tags;
}
