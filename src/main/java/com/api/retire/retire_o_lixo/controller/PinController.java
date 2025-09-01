package com.api.retire.retire_o_lixo.controller;

import com.api.retire.retire_o_lixo.model.Pin;
import com.api.retire.retire_o_lixo.service.PinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pins")    
@CrossOrigin(origins = "*") // libera todas as origens
public class PinController {

    @Autowired
    private PinService pinService ;

    @PostMapping
    public ResponseEntity<List<Pin>> SalvarPins(@RequestBody List<Pin> pins) {
    List<Pin> salvos = pinService.salvarPins(pins);
        return ResponseEntity.ok(salvos);
    }
    

    @GetMapping
    public ResponseEntity<List<Pin>> listarPins(@RequestParam(required = false) String cidade) {
        if (cidade != null) {
            return ResponseEntity.ok(pinService.buscarPorCidade(cidade));
        } else {
            return ResponseEntity.ok(pinService.listarPins());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pin> buscarPorId(@PathVariable String id) {
        return pinService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
