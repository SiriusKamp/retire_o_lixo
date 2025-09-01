package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bairros")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_bairro")
    private String cdBairro;

    @Column(name = "nm_bairro")
    private String nmBairro;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "uf")
    private String uf;

    // O campo geom normalmente é um tipo Geometry do Hibernate Spatial / JTS
    // Se você só vai inserir via query nativa, pode deixar como String ou Object
    @Column(name = "geom", columnDefinition = "geometry")
    private String geom;
}
