package com.proyecto.aprendizaje.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCurso;
  private String nombre;
  @Column(length = 400)
  private String descripcion;
  private double precio;
  private String nivel;
  private String img;
  private String instrumento;
  private String profesor;
  private int estado;
  @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
  private List<Inscripcion> inscripciones;

}
