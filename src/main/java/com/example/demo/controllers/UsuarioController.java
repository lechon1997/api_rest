package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody UsuarioModel usuario){
        if(usuario.getPrioridad() < 1 || usuario.getPrioridad() > 10){
            return new ResponseEntity("Prioridad inválida",HttpStatus.BAD_REQUEST);
        }

        if(usuario.getEdad() < 18){
            return new ResponseEntity("Edad inválida",HttpStatus.BAD_REQUEST);
        }

        if(!usuario.getSexo().equals("H") && !usuario.getSexo().equals("M")){
            return new ResponseEntity("El sexo es incorrecto",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping( path = "/listarPorPrioridad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id " + id;
        }

        return "No se pudo eliminar el usuario con id " + id;
    }

    @GetMapping( path = "/listarPorSexo")
    public ArrayList<UsuarioModel> obtenerUsuarioPorSexo(@RequestParam("sexo") String sexo){
        return this.usuarioService.listarPorSexo(sexo);
    }

    @GetMapping(path = "/listarAsc")
    public ArrayList<UsuarioModel> listarUsuariosAscEdad(){
        return usuarioService.listarUsuariosPorEdadAsc();
    }

    @GetMapping(path = "/listarDesc")
    public ArrayList<UsuarioModel>listarUsuariosDescEdad(){
        return usuarioService.listarUsuariosPorEdadDesc();
    }

    @GetMapping(path = "/listarPorEdad")
    public ArrayList<UsuarioModel> listarUsuariosPorEdad(@RequestParam("edad") Integer edad){
        return usuarioService.listarPorEdad(edad);
    }
}
