package com.proyecto.aprendizaje.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.aprendizaje.entidad.InscripcionDTO;
import com.proyecto.aprendizaje.servicio.CursoService;
import com.proyecto.aprendizaje.servicio.InscripcionService;

@Controller
public class PrincipalControlador {

  @Autowired
  private CursoService cursoService;
  @Autowired
  private InscripcionService inscripcionService;

  @GetMapping("/inicio")
  public String inicio(){
    return "index";
  }

  @GetMapping("/login")
  public String loginForm(){
    return "login";
  }

  @GetMapping("/cursos")
  public String cursosPage(Model model){
    model.addAttribute("cursos", cursoService.cursos() );
    return "cursos";
  }
  

  @GetMapping("/reportes")
  public String reportes(Model model){
    List<InscripcionDTO> inscripcionDTOs = inscripcionService.geInscripcionDTOs();
    model.addAttribute("inscripciones", inscripcionDTOs);
    return "reportes";
  }
  
}
