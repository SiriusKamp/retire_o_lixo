package com.api.retire.retire_o_lixo.controller;

import com.api.retire.retire_o_lixo.DTO.HorariosDTO;
import com.api.retire.retire_o_lixo.model.Horarios;
import com.api.retire.retire_o_lixo.service.HorariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @CrossOrigin(origins = "*") // ou coloque seu domínio específico
    @GetMapping
        public List<Horarios> getHorarios() {
        return horariosService.getHorarios();
    }
    @CrossOrigin(origins = "*") // ou coloque seu domínio específico
    @GetMapping("/bairro")
    public Horarios getHorariosbybairro(@RequestParam Long id) {
    return horariosService.getHorariosbybairro(id);
}
}
