package com.proyecto.aprendizaje.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.aprendizaje.entidad.Usuario;
import com.proyecto.aprendizaje.repositorio.UsuarioRespositorio;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRespositorio usuarioRespositorio;

  public Usuario validarUsuario(String correo, String contrasena){
    return usuarioRespositorio.validarUsuario(correo, contrasena);
  }

  public Usuario getByDni(String dni){
    return usuarioRespositorio.usuarioPorDni(dni);
  }

  public Usuario registrar(Usuario usuario){
    return usuarioRespositorio.save(usuario);
  }
  
}
