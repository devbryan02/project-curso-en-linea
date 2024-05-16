package com.proyecto.aprendizaje.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.aprendizaje.entidad.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer>{
  
}
