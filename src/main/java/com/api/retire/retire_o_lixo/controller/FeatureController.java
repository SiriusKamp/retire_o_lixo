package com.api.retire.retire_o_lixo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.retire.retire_o_lixo.model.FeatureDTO;
import com.api.retire.retire_o_lixo.service.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private final FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> uploadFeatures(@RequestBody List<FeatureDTO> features) {
        service.saveFeatures(features);
        return ResponseEntity.ok("Features salvas com sucesso!");
    }
}
