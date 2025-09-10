package com.api.retire.retire_o_lixo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.retire.retire_o_lixo.DTO.BairroGeoDTO;
// Update the import below to the correct package where GeoJsonDTO exists
import com.api.retire.retire_o_lixo.DTO.GeoJsonDTO;
import com.api.retire.retire_o_lixo.repository.BairroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/bairros")
public class BairroController {

    @Autowired
    private BairroRepository bairroRepository;

    @PostMapping
    public ResponseEntity<String> salvarBairros(@RequestBody GeoJsonDTO geoJsonDTO) {
        ObjectMapper mapper = new ObjectMapper();

        geoJsonDTO.getFeatures().forEach(feature -> {
            try {
                // transforma só a parte da geometria em string JSON
                String geometryJson = mapper.writeValueAsString(feature.getGeometry());

                bairroRepository.salvarBairro(
                    feature.getProperties().getCD_BAIRRO(),
                    feature.getProperties().getNM_BAIRRO(),
                    feature.getProperties().getNM_MUN(),
                    feature.getProperties().getNM_UF(),
                    geometryJson
                );
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Erro ao processar geometry JSON", e);
            }
        });

        return ResponseEntity.ok("Bairros inseridos com sucesso!");
    }

    @GetMapping("")
    public List<BairroGeoDTO> getBairros() {
        List<Object[]> resultados = bairroRepository.buscarBairrosComGeoJson();
        List<BairroGeoDTO> bairros = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
    
        for (Object[] linha : resultados) {
            Long id = (Long) linha[0];
            String cdBairro = (String) linha[1];
            String nmBairro = (String) linha[2];
            String municipio = (String) linha[3];
            String uf = (String) linha[4];
            String geojson = (String) linha[5];
    
            try {
                JsonNode root = mapper.readTree(geojson);
                JsonNode coordsNode = root.get("coordinates");
    
                // Se for Polygon, transforma em MultiPolygon
                if ("Polygon".equals(root.get("type").asText())) {
                    // Wrap para manter formato consistente
                    coordsNode = mapper.readTree("[" + coordsNode.toString() + "]");
                }
    
                List<List<List<Double>>> coordinates = new ArrayList<>();
                for (JsonNode polygon : coordsNode) {
                    List<List<Double>> poly = new ArrayList<>();
                    for (JsonNode point : polygon.get(0)) {
                        poly.add(Arrays.asList(
                            point.get(0).asDouble(),
                            point.get(1).asDouble()
                        ));
                    }
                    coordinates.add(poly);
                }
    
                BairroGeoDTO dto = new BairroGeoDTO();
                dto.setId(id);
                dto.setCdBairro(cdBairro);
                dto.setNmBairro(nmBairro);
                dto.setMunicipio(municipio);
                dto.setUf(uf);
                dto.setCoordinates(coordinates);
    
                bairros.add(dto);
            } catch (Exception e) {
                e.printStackTrace(); // ou log
            }
        }
    
        return bairros;
    }
}    
