package com.proyecto.aprendizaje.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reporte")
public class Reporte {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idReporte;
  @ManyToOne
  @JoinColumn(name = "idInscripcion", referencedColumnName = "idInscripcion")
  private Inscripcion inscripcion;
  private String detalle;

}
