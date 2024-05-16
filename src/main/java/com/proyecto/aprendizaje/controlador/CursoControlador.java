package com.proyecto.aprendizaje.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.aprendizaje.entidad.Curso;
import com.proyecto.aprendizaje.entidad.Inscripcion;
import com.proyecto.aprendizaje.entidad.Usuario;
import com.proyecto.aprendizaje.servicio.CursoService;
import com.proyecto.aprendizaje.servicio.InscripcionService;
import com.proyecto.aprendizaje.servicio.UsuarioService;

@Controller
@RequestMapping("/curso")
public class CursoControlador {

  @Autowired
  private CursoService cursoService;

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private InscripcionService inscripcionService;

  @GetMapping("registro")
  public String registroForm(Model model) {
    model.addAttribute("curso", new Curso());
    return "registroCurso";
  }

  @PostMapping("/registro-curso")
  public String registroCurso(@ModelAttribute Curso curso, MultipartFile file) {
    try {
      String img = file.getOriginalFilename();
      curso.setImg(img);
      curso.setEstado(1);
      cursoService.uploadImg(file);
      cursoService.registrarCurso(curso);
    } catch (IOException e) {
      e.printStackTrace(System.out);
    }
    return "redirect:/cursos";
  }

  @GetMapping("/inscripcion")
  public String inscripcionForm(Model model) {
    model.addAttribute("inscripcion", new Inscripcion());
    model.addAttribute("cursos", cursoService.cursos());
    return "inscripcion";
  }

  @PostMapping("/inscripcion-curso")
  public String inscripcionCurso(@ModelAttribute Inscripcion inscripcion,
      @RequestParam("dni") String dni) {
    Usuario usuario = usuarioService.getByDni(dni);
    inscripcion.setUsuario(usuario);
    LocalDate date = LocalDate.now();
    Date fechaActual = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    inscripcion.setFecha(fechaActual);
    inscripcionService.registrar(inscripcion);
    return "redirect:/curso/inscripcion";
  }


}
