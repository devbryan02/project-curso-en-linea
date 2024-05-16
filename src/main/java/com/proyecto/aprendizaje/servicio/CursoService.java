package com.proyecto.aprendizaje.servicio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.aprendizaje.entidad.Curso;
import com.proyecto.aprendizaje.repositorio.CursoRepositorio;

@Service
public class CursoService {

  @Autowired
  private CursoRepositorio cursoRepositorio;

  public Curso registrarCurso(Curso curso){
    return cursoRepositorio.save(curso);
  }

  public List<Curso> cursos(){
    return cursoRepositorio.findAll();
  }

  public void uploadImg(MultipartFile file) throws IOException{
    String dir = "src/main/resources/static/upload/";
    if(!file.isEmpty()){
            String pathImg= dir+file.getOriginalFilename();
            Path pathFile = Paths.get(pathImg);
            Files.copy(file.getInputStream(), pathFile,
                    StandardCopyOption.REPLACE_EXISTING);
        }

  }
  
}
