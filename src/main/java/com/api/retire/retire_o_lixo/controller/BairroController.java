package com.api.retire.retire_o_lixo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// Update the import below to the correct package where GeoJsonDTO exists
import com.api.retire.retire_o_lixo.DTO.GeoJsonDTO;
import com.api.retire.retire_o_lixo.repository.BairroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public List<Object[]> GetBairros() {
        return bairroRepository.buscarBairrosComGeoJson();
    }
    
}
