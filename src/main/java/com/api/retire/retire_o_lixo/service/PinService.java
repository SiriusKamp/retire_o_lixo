package com.api.retire.retire_o_lixo.service;

import com.api.retire.retire_o_lixo.model.PinRequest;
import com.api.retire.retire_o_lixo.model.Pin;
import com.api.retire.retire_o_lixo.repository.PinRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinService {

    private final PinRepository pinRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    public PinService(PinRepository pinRepository) {
        this.pinRepository = pinRepository;
    }

    public List<Pin> salvarPins(List<PinRequest> requests) {
        List<Pin> pins = requests.stream().map(request -> {
            Point point = geometryFactory.createPoint(new Coordinate(request.getLongitude(), request.getLatitude()));
            point.setSRID(4326);
    
            Pin pin = new Pin();
            pin.setNome(request.getNome());
            pin.setDescricao(request.getDescricao());
            pin.setCidade(request.getCidade());
            pin.setLocalizacao(point);
            pin.setTags(request.getTags().toArray(new String[0]));
    
            return pin;
        }).toList();
    
        return pinRepository.saveAll(pins);
    }
<<<<<<< HEAD
public List<Pin> salvarTodos(List<Pin> pins) {
        return pinRepository.saveAll(pins);
    }
=======
    
>>>>>>> ce803108bfc670ac76c76e266d30818db22d37f9
    public List<Pin> listarPins() {
        return pinRepository.findAll();
    }

    public Optional<Pin> buscarPorId(String id) {
        return pinRepository.findById(id);
    }

    public List<Pin> buscarPorCidade(String cidade) {
        return pinRepository.findByCidade(cidade);
    }
}
