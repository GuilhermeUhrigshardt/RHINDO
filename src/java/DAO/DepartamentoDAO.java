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
    
    String buscarPorNome = "select idDepartamento, nomeDepartamento, localizacao from Departamento where nomeDepartamento like ? order by idDepartamento";    
    String buscarTodos = "select idDepartamento, nomeDepartamento, localizacao from Departamento order by idDepartamento";
    
    public List<Departamento> buscarDepartamentos(String razao) throws SQLException, ClassNotFoundException {
        List<Departamento> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarPorNome);
            stmt.setString(1, "%" + razao + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                //e.setCodDepartamento(rs.getInt("id_empresa"));
                //e.setCnpj(rs.getString("cnpj"));
                //e.setRazaoSocial(rs.getString("razao_social"));
                //e.setEndereco(rs.getString("endereco"));
                //e.setEmail(rs.getString("email"));
                //lista.add(e);
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
    
    public List<Departamento> buscarTodas() throws SQLException, ClassNotFoundException {
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
}
