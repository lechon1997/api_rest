package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true,nullable=false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;
    private Integer edad;
    private String sexo;

    public UsuarioModel() {
    }

    public UsuarioModel(String nombre, String email, Integer prioridad, Integer edad, String sexo) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void nombreToUpperCase() {
        this.nombre = this.nombre.toUpperCase();
    }

    public void sexoToUpperCase() {
        this.sexo = this.sexo.toUpperCase();
    }

}
