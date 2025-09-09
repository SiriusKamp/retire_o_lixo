package com.api.retire.retire_o_lixo.DTO;

import lombok.Data;

@Data
public class UsuarioCreateDTO {
    private String email;
    private String senha;
    private String apelido;
    private Long bairro; // opcional
}
