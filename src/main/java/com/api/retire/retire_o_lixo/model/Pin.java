package com.api.retire.retire_o_lixo.model;

import java.util.List;


import jakarta.persistence.*;
import lombok.*;

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
    private String latitude;

    
    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private List<String> tags;
}
