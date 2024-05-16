package com.proyecto.aprendizaje.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.aprendizaje.entidad.Inscripcion;
import com.proyecto.aprendizaje.entidad.InscripcionDTO;

@Repository
public interface InscripcionRespositorio extends JpaRepository<Inscripcion, Integer> {

  @Query("SELECT new com.proyecto.aprendizaje.entidad.InscripcionDTO(i.idInscripcion, i.usuario.nombre, i.usuario.telefono, i.curso.nombre) FROM Inscripcion i")
  List<InscripcionDTO> geInscripcionDTOs();

}
