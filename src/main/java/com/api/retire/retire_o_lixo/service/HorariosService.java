package com.api.retire.retire_o_lixo.service;

import com.api.retire.retire_o_lixo.DTO.HorariosDTO;
import com.api.retire.retire_o_lixo.model.Horarios;
import com.api.retire.retire_o_lixo.repository.HorariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HorariosService {

 @Autowired
 private HorariosRepository horariosRepository;

 public void salvarHorarios(List<HorariosDTO> listaHorarios) {
  for (HorariosDTO dto : listaHorarios) {
   // Transforma o Map em arrays
   List<String> diasList = new ArrayList<>(dto.getDias().keySet());
   List<String> horariosList = new ArrayList<>();

   dto.getDias().forEach((dia, horarios) -> {
    horarios.forEach(horario -> {
     horariosList.add(dia + " " + horario); // exemplo "Ter 07:00-16:40"
    });
   });

   horariosRepository.salvarHorario(
     dto.getBairro(),
     horariosList.toArray(new String[0]),
     diasList.toArray(new String[0]));
  }
 }

 public List<Horarios> getHorarios(){
  return horariosRepository.getHorarios();
 }

 public Horarios getHorariosbybairro(Long id){
  return horariosRepository.getHorariosbyBairro(id);
 }
}
