package com.api.retire.retire_o_lixo.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HorariosDTO {
    private String bairro;
    private Map<String, List<String>> dias;

    // Getters e Setters
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Map<String, List<String>> getDias() {
        return dias;
    }

    public void setDias(Map<String, List<String>> dias) {
        this.dias = dias;
    }
}
