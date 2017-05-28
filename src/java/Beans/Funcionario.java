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
public class Funcionario implements Serializable {
    private int idFuncionario;
    private String email;
    private String nomeFuncionario;
    private String cpf;
    private String rg;
    private String celular;
    private String senha;
    private Endereco endereco;
    private Cargo cargo;
    private Departamento departamento;
    
    public Funcionario() {
        
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public boolean validaFuncionario(Funcionario funcionario) {
        if (funcionario.getCelular().length()!= 11)
            return false;
        if (funcionario.getCpf().length() != 11)
            return false;
        if (funcionario.getEndereco().getCep().length() != 8)
            return false;
        if (funcionario.getCargo() == null|| funcionario.getDepartamento() == null || funcionario.getEmail().equals("")|| funcionario.getEndereco() == null || funcionario.getNomeFuncionario().equals("") || funcionario.getSenha().equals(""))
            return false;
        return funcionario.getRg().length() == 9;
    }
}
