package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<UsuarioModel> listarPorSexo(String sexo){
        return usuarioRepository.findBySexo(sexo);
    }

    public List<UsuarioModel> listarUsuariosPorEdadAsc(){
        List<UsuarioModel> users = (ArrayList<UsuarioModel>)usuarioRepository.findAll();
        users.sort(( x, y) -> x.getEdad().compareTo(y.getEdad()));
        return users;
    }

    public List<UsuarioModel> listarUsuariosPorEdadDesc(){
        List<UsuarioModel> users = (ArrayList<UsuarioModel>)usuarioRepository.findAll();
        users.sort(( x, y) -> y.getEdad().compareTo(x.getEdad()));
        return users;
    }

    public ArrayList<UsuarioModel> listarPorEdad(Integer edad){
        return usuarioRepository.findByEdad(edad);
    }


}
