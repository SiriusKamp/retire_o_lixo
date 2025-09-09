package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "horarios")
@Data
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bairro_id", nullable = false)
    private Long bairroId;

    @Column(name = "nome_bairro", nullable = false)
    private String nomeBairro;

    // Arrays de texto no Postgres podem ser mapeados como List<String>
    @Column(name = "Dia_horario", columnDefinition = "varchar[]", nullable = false)
    private List<String> diaHorario;

    @Column(name = "Dias", columnDefinition = "varchar[]", nullable = false)
    private List<String> dias;
}
