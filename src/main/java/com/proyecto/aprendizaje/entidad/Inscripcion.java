package com.proyecto.aprendizaje.entidad;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscripcion")
public class Inscripcion {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idInscripcion;
  @ManyToOne
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  private Usuario usuario;
  @ManyToOne
  @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
  private Curso curso;
  @Temporal(TemporalType.DATE)
  private Date fecha;
  @OneToMany(mappedBy = "inscripcion", cascade = CascadeType.ALL)
  private List<Reporte> reportes;

}
