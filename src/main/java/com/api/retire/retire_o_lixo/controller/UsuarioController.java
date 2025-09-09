package com.api.retire.retire_o_lixo.controller;

import com.api.retire.retire_o_lixo.DTO.*;
import com.api.retire.retire_o_lixo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public UsuarioResponseDTO register(@RequestBody UsuarioCreateDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @PostMapping("/login")
    public UsuarioResponseDTO login(@RequestBody UsuarioLoginDTO dto) {
        return usuarioService.login(dto);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO update(@PathVariable Long id,
                                     @RequestParam(required = false) String apelido,
                                     @RequestParam(required = false) Long bairro) {
        return usuarioService.atualizar(id, apelido, bairro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
