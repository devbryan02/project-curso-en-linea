package com.proyecto.aprendizaje.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.aprendizaje.entidad.Usuario;
import com.proyecto.aprendizaje.servicio.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/registro")
  public String registroForm(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "registroUsuario";
  }

  @PostMapping("/registro-usuario")
  public String registrarUsuario(@ModelAttribute Usuario usuario) {
    usuario.setRol("Estudiante");
    usuarioService.registrar(usuario);
    return "redirect:/login";
  }

  @PostMapping("/validar")
  public String validarUsuario(@RequestParam("correo") String correo,
      @RequestParam("contrasena") String contrasena,
      Model model) {
        String rolAdmin = "Administrador";
        String rolEstudiante = "Estudiante";
        Usuario usuario = usuarioService.validarUsuario(correo, contrasena);
        if(usuario != null){
          if(rolAdmin.equals(usuario.getRol())){
            return "redirect:/curso/registro";
          }
          else if(rolEstudiante.equals(usuario.getRol())){
            return "redirect:/inicio";
          }
        }
        model.addAttribute("mensaje","Correo o contraseña invalida");
        return "login";
  }

}
