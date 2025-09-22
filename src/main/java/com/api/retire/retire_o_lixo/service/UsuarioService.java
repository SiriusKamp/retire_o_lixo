package com.api.retire.retire_o_lixo.service;

import com.api.retire.retire_o_lixo.DTO.*;
import com.api.retire.retire_o_lixo.model.Usuario;
import com.api.retire.retire_o_lixo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
private PasswordEncoder passwordEncoder;


    public UsuarioResponseDTO criarUsuario(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setApelido(dto.getApelido());
        usuario.setBairro(dto.getBairro());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha())); // senha com hash

        Usuario salvo = usuarioRepository.save(usuario);

        return toResponseDTO(salvo);
    }

    public UsuarioResponseDTO login(UsuarioLoginDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(dto.getEmail());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
                return toResponseDTO(usuario);
            }
        }
        throw new RuntimeException("Email ou senha inválidos!");
    }

    public UsuarioResponseDTO atualizar(Long id, String apelido, Long bairro) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        if (apelido != null) usuario.setApelido(apelido);
        if (bairro != null) usuario.setBairro(bairro);

        return toResponseDTO(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setEmail(usuario.getEmail());
        dto.setApelido(usuario.getApelido());
        dto.setBairro(usuario.getBairro());
        return dto;
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return toResponseDTO(usuario);
    }
}
