package com.api.retire.retire_o_lixo.DTO;

import lombok.Data;
import java.util.List;

@Data
public class BairroGeoDTO {
    private String cdBairro;
    private String nmBairro;
    private String municipio;
    private String uf;
    private List<List<List<Double>>> coordinates; // polygon: [[[lon, lat], ...]]
}