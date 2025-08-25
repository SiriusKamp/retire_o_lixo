package com.api.retire.retire_o_lixo.service;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import com.api.retire.retire_o_lixo.model.FeatureDTO;
import com.api.retire.retire_o_lixo.model.FeatureEntity;
import com.api.retire.retire_o_lixo.repository.FeatureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    private final FeatureRepository repository;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    public FeatureService(FeatureRepository repository) {
        this.repository = repository;
    }

    public void saveFeatures(List<FeatureDTO> features) {
        List<FeatureEntity> entities = features.stream().map(this::convertToEntity).collect(Collectors.toList());
        repository.saveAll(entities);
    }

    private FeatureEntity convertToEntity(FeatureDTO dto) {
        FeatureEntity entity = new FeatureEntity();
        // Criar Polygon a partir de coordenadas
        double[][][] coords = dto.getGeometry().getCoordinates();
        Coordinate[] polygonCoords = new Coordinate[coords[0].length];
        for (int i = 0; i < coords[0].length; i++) {
            polygonCoords[i] = new Coordinate(coords[0][i][0], coords[0][i][1]);
        }
        Polygon polygon = geometryFactory.createPolygon(polygonCoords);
        entity.setGeometry(polygon);

        // Mapear properties
        FeatureDTO.PropertiesDTO p = dto.getProperties();
        entity.setCdRegiao(p.getCD_REGIAO());
        entity.setNmRegiao(p.getNM_REGIAO());
        entity.setCdUf(p.getCD_UF());
        entity.setNmUf(p.getNM_UF());
        entity.setCdMun(p.getCD_MUN());
        entity.setNmMun(p.getNM_MUN());
        entity.setCdDist(p.getCD_DIST());
        entity.setNmDist(p.getNM_DIST());
        entity.setCdSubdist(p.getCD_SUBDIST());
        entity.setNmSubdist(p.getNM_SUBDIST());
        entity.setCdBairro(p.getCD_BAIRRO());
        entity.setNmBairro(p.getNM_BAIRRO());
        entity.setCdRgint(p.getCD_RGINT());
        entity.setNmRgint(p.getNM_RGINT());
        entity.setCdRgi(p.getCD_RGI());
        entity.setNmRgi(p.getNM_RGI());
        entity.setCdConcurb(p.getCD_CONCURB());
        entity.setNmConcurb(p.getNM_CONCURB());

        return entity;
    }
}
