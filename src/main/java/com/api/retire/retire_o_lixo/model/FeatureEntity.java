package com.api.retire.retire_o_lixo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Polygon;

@Entity
@Table(name = "features")
public class FeatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "geometry(Polygon, 4326)")
    private Polygon geometry;

    private String cdRegiao;
    private String nmRegiao;
    private String cdUf;
    private String nmUf;
    private String cdMun;
    private String nmMun;
    private String cdDist;
    private String nmDist;
    private String cdSubdist;
    private String nmSubdist;
    private String cdBairro;
    private String nmBairro;
    private String cdRgint;
    private String nmRgint;
    private String cdRgi;
    private String nmRgi;
    private String cdConcurb;
    private String nmConcurb;
    public Long getId() {
     return id;
    }
    public void setId(Long id) {
     this.id = id;
    }
    public Polygon getGeometry() {
     return geometry;
    }
    public void setGeometry(Polygon geometry) {
     this.geometry = geometry;
    }
    public String getCdRegiao() {
     return cdRegiao;
    }
    public void setCdRegiao(String cdRegiao) {
     this.cdRegiao = cdRegiao;
    }
    public String getNmRegiao() {
     return nmRegiao;
    }
    public void setNmRegiao(String nmRegiao) {
     this.nmRegiao = nmRegiao;
    }
    public String getCdUf() {
     return cdUf;
    }
    public void setCdUf(String cdUf) {
     this.cdUf = cdUf;
    }
    public String getNmUf() {
     return nmUf;
    }
    public void setNmUf(String nmUf) {
     this.nmUf = nmUf;
    }
    public String getCdMun() {
     return cdMun;
    }
    public void setCdMun(String cdMun) {
     this.cdMun = cdMun;
    }
    public String getNmMun() {
     return nmMun;
    }
    public void setNmMun(String nmMun) {
     this.nmMun = nmMun;
    }
    public String getCdDist() {
     return cdDist;
    }
    public void setCdDist(String cdDist) {
     this.cdDist = cdDist;
    }
    public String getNmDist() {
     return nmDist;
    }
    public void setNmDist(String nmDist) {
     this.nmDist = nmDist;
    }
    public String getCdSubdist() {
     return cdSubdist;
    }
    public void setCdSubdist(String cdSubdist) {
     this.cdSubdist = cdSubdist;
    }
    public String getNmSubdist() {
     return nmSubdist;
    }
    public void setNmSubdist(String nmSubdist) {
     this.nmSubdist = nmSubdist;
    }
    public String getCdBairro() {
     return cdBairro;
    }
    public void setCdBairro(String cdBairro) {
     this.cdBairro = cdBairro;
    }
    public String getNmBairro() {
     return nmBairro;
    }
    public void setNmBairro(String nmBairro) {
     this.nmBairro = nmBairro;
    }
    public String getCdRgint() {
     return cdRgint;
    }
    public void setCdRgint(String cdRgint) {
     this.cdRgint = cdRgint;
    }
    public String getNmRgint() {
     return nmRgint;
    }
    public void setNmRgint(String nmRgint) {
     this.nmRgint = nmRgint;
    }
    public String getCdRgi() {
     return cdRgi;
    }
    public void setCdRgi(String cdRgi) {
     this.cdRgi = cdRgi;
    }
    public String getNmRgi() {
     return nmRgi;
    }
    public void setNmRgi(String nmRgi) {
     this.nmRgi = nmRgi;
    }
    public String getCdConcurb() {
     return cdConcurb;
    }
    public void setCdConcurb(String cdConcurb) {
     this.cdConcurb = cdConcurb;
    }
    public String getNmConcurb() {
     return nmConcurb;
    }
    public void setNmConcurb(String nmConcurb) {
     this.nmConcurb = nmConcurb;
    }

    // Getters e Setters
}
