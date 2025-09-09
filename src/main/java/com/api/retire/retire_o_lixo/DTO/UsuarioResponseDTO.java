package com.api.retire.retire_o_lixo.DTO;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String email;
    private String apelido;
    private Long bairro;
}
