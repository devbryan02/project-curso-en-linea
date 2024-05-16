package com.proyecto.aprendizaje.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.aprendizaje.entidad.Usuario;

@Repository
public interface UsuarioRespositorio extends JpaRepository<Usuario, Integer> {

  @Query("SELECT u FROM Usuario u " +
      "WHERE u.correo = :correo " +
      "AND u.contrasena = :contrasena " +
      "AND (u.rol = 'Estudiante' OR u.rol = 'Administrador')")
  Usuario validarUsuario(@Param(value = "correo") String correo, @Param(value = "contrasena") String contrasena);

  // Obtener un usuario por su dni
  @Query("SELECT u FROM Usuario u WHERE u.dni=:dni")
  Usuario usuarioPorDni(@Param(value = "dni") String dni);

}
