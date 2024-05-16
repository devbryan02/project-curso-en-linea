package com.proyecto.aprendizaje.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aprendizaje.entidad.Inscripcion;
import com.proyecto.aprendizaje.entidad.InscripcionDTO;
import com.proyecto.aprendizaje.repositorio.InscripcionRespositorio;

@Service
public class InscripcionService {

  @Autowired
  private InscripcionRespositorio inscripcionRespositorio;

  public Inscripcion registrar(Inscripcion inscripcion){
    return inscripcionRespositorio.save(inscripcion);
  }

  public List<InscripcionDTO> geInscripcionDTOs(){
    return inscripcionRespositorio.geInscripcionDTOs();
  }
  
}
