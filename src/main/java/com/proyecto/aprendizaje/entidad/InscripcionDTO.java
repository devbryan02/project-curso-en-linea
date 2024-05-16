package com.proyecto.aprendizaje.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscripcionDTO {

  private Integer idInscripcion;
  private String nombreUsuario;
  private String telefonoUsuario;
  private String nombreCurso;

}
