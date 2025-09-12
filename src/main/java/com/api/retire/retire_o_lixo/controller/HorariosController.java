package com.api.retire.retire_o_lixo.controller;

import com.api.retire.retire_o_lixo.DTO.HorariosDTO;
import com.api.retire.retire_o_lixo.model.Horarios;
import com.api.retire.retire_o_lixo.service.HorariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/horarios")
public class HorariosController {

    @Autowired
    private HorariosService horariosService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody List<HorariosDTO> horarios) {
        horariosService.salvarHorarios(horarios);
        return ResponseEntity.ok("Horários salvos com sucesso!");
    }

    @GetMapping
        public List<Horarios> getHorarios() {
        return horariosService.getHorarios();
    }
    
}
