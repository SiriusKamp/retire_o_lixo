package com.api.retire.retire_o_lixo.service;

import com.api.retire.retire_o_lixo.model.Pin;
import com.api.retire.retire_o_lixo.repository.PinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinService {

    private final PinRepository pinRepository;

    public PinService(PinRepository pinRepository) {
        this.pinRepository = pinRepository;
    }

    public Pin salvarPin(Pin pin) {
        return pinRepository.save(pin);
    }
public List<Pin> salvarTodos(List<Pin> pins) {
        return pinRepository.saveAll(pins);
    }
    public List<Pin> listarPins() {
        return pinRepository.findAll();
    }

    public Optional<Pin> buscarPorId(String id) {
        return pinRepository.findById(id);
    }

    public List<Pin> buscarPorCidade(String cidade) {
        return pinRepository.findByCidade(cidade);
    }

    public List<Pin> buscarPorTag(String tag) {
        return pinRepository.findByTagsContaining(tag);
    }
}
