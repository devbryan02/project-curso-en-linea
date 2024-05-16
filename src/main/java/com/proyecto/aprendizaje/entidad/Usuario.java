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
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuario;
  @Column(length = 8, unique = true)
  private String dni;
  private String nombre;
  private String apellidos;
  private String telefono;
  @Column(unique = true)
  private String correo;
  private String contrasena;
  private String rol;
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  private List<Inscripcion> inscripciones;
  
}
