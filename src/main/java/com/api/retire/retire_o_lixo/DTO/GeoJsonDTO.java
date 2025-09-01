package com.api.retire.retire_o_lixo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GeoJsonDTO {
    private String type;
    private List<Feature> features;

    @Data
    public static class Feature {
        private Geometry geometry;
        private Properties properties; 
    }

    @Data
    public static class Geometry {
        private String type; // "Polygon" ou "MultiPolygon"
        private Object coordinates; // pode ser List<List<List<Double>>> ou List<List<List<List<Double>>>>
    }

@Data
public static class Properties 
{
 
    @JsonProperty("CD_BAIRRO")
    private String CD_BAIRRO;

    @JsonProperty("NM_BAIRRO")
    private String NM_BAIRRO;

    @JsonProperty("NM_MUN")
    private String NM_MUN;

    @JsonProperty("NM_UF")
    private String NM_UF;
}

}
