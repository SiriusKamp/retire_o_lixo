package com.api.retire.retire_o_lixo.model;

import lombok.Data;

import java.util.List;

@Data
public class PinRequest {
    private String nome;
    private String descricao;
    private String cidade;
    private Double latitude;
    private Double longitude;
    private List<String> tags;
}
