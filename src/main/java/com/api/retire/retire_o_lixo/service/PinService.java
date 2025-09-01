package com.api.retire.retire_o_lixo.service;

import com.api.retire.retire_o_lixo.model.Pin;
import com.api.retire.retire_o_lixo.repository.PinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinService {

    @Autowired
    private PinRepository pinRepository;


    public List<Pin> listarPins() {
        return pinRepository.findAll();
    }

    public Optional<Pin> buscarPorId(String id) {
        return pinRepository.findById(id);
    }

    public List<Pin> salvarPins(List<Pin> pins)
    {
        return pinRepository.saveAll(pins);
        
    }
    public List<Pin> buscarPorCidade(String cidade) {
        return pinRepository.findByCidade(cidade);
    }
}
