package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    // Senha armazenada com hash (BCrypt)
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String apelido;

    @Column
    private Long bairro;
}
