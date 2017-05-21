/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Cargo implements Serializable {
    private String nome;
    private float salario;
    private String requisitos;
    private int cargaMinima;
    private float descontoImpostos;
    
    public Cargo() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public int getCargaMinima() {
        return cargaMinima;
    }

    public void setCargaMinima(int cargaMinima) {
        this.cargaMinima = cargaMinima;
    }

    public float getDescontoImpostos() {
        return descontoImpostos;
    }

    public void setDescontoImpostos(float descontoImpostos) {
        this.descontoImpostos = descontoImpostos;
    }
    
    
}
