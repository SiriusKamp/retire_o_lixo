package com.api.retire.retire_o_lixo.controller;

import com.api.retire.retire_o_lixo.model.Pin;
import com.api.retire.retire_o_lixo.service.PinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pins")
public class PinController {

    private final PinService pinService;

    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @PostMapping
    public ResponseEntity<Pin> criarPin(@RequestBody Pin pin) {
        return ResponseEntity.ok(pinService.salvarPin(pin));
    }

    @GetMapping
    public ResponseEntity<List<Pin>> listarPins(@RequestParam(required = false) String cidade,
                                                @RequestParam(required = false) String tag) {
        if (cidade != null) {
            return ResponseEntity.ok(pinService.buscarPorCidade(cidade));
        } else if (tag != null) {
            return ResponseEntity.ok(pinService.buscarPorTag(tag));
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
