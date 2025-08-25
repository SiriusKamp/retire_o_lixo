package com.api.retire.retire_o_lixo.model;

import lombok.Data;

@Data
public class FeatureDTO {
    private String type;
    private GeometryDTO geometry;
    private PropertiesDTO properties;

    @Data
    public static class GeometryDTO {
        private String type;
        private double[][][] coordinates;
    }

    @Data
    public static class PropertiesDTO {
        private String CD_REGIAO;
        private String NM_REGIAO;
        private String CD_UF;
        private String NM_UF;
        private String CD_MUN;
        private String NM_MUN;
        private String CD_DIST;
        private String NM_DIST;
        private String CD_SUBDIST;
        private String NM_SUBDIST;
        private String CD_BAIRRO;
        private String NM_BAIRRO;
        private String CD_RGINT;
        private String NM_RGINT;
        private String CD_RGI;
        private String NM_RGI;
        private String CD_CONCURB;
        private String NM_CONCURB;
    }
}
