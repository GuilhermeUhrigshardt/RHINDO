/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Departamento;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class DepartamentoDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;    
    private String buscarPorNome = "select idDepartamento, nomeDepartamento, localizacao from Departamento where nomeDepartamento like ? order by idDepartamento";    
    private String buscarTodos = "select idDepartamento, nomeDepartamento, localizacao from Departamento order by idDepartamento";
    private String buscarNome = "select nomeDepartamento from Departamento order by idDepartamento";
    private String buscarPorId = "select idDepartamento, nomeDepartamento, localizacao from Departamento where idDepartamento = ?";
    private String atualizarDepartamento = "update Departamento set nomeDepartamento = ?, localizacao = ? where idDepartamento = ?";
    
    public List<Departamento> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        List<Departamento> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarPorNome);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNomeDepartamento(rs.getString("nomeDepartamento"));
                d.setLocalizacao(rs.getString("localizacao"));
                lista.add(d);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Departamentos: " + ex.getMessage());
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
        return lista;
    }
    
    public List<Departamento> buscarTodos() throws SQLException, ClassNotFoundException {
        List<Departamento> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarTodos);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNomeDepartamento(rs.getString("nomeDepartamento"));
                d.setLocalizacao(rs.getString("localizacao"));
                lista.add(d);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Departamentos: " + ex.getMessage());
        } finally {
            stmt.close();
            con.close();
        }
        return lista;
    }
    
    public List<Departamento> buscarNomes(String nome) throws SQLException, ClassNotFoundException {
        List<Departamento> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarNome);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setNomeDepartamento(rs.getString("nomeDepartamento"));
                lista.add(d);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Departamentos: " + ex.getMessage());
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
        return lista;
    }
    
    public Departamento buscarPorId(int id) throws SQLException, ClassNotFoundException {
        Departamento d = new Departamento();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarPorId);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNomeDepartamento(rs.getString("nomeDepartamento"));
                d.setLocalizacao(rs.getString("localizacao"));
            }
            return d;
        } catch (SQLException ex) {
            out.println("Erro ao listar Departamentos: " + ex.getMessage());
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
        return d;
    }
    
    public void atualizarDepartamento(Departamento departamento) throws SQLException, ClassNotFoundException {
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizarDepartamento);
            stmt.setString(1, departamento.getNomeDepartamento());
            stmt.setString(2, departamento.getLocalizacao());
            stmt.setInt(3, departamento.getIdDepartamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            out.println("Erro ao listar Departamentos: " + ex.getMessage());
        } finally {
            stmt.close();
            con.close();
        }
    }
}
