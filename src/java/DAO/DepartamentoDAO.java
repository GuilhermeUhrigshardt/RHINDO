/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class DepartamentoDAO {
    private String stmtBuscaDepartamento = "SELECT nomeDepartamento, localizacao FROM departamento WHERE idDepartamento = ?";
    
    public Departamento lerDepartamento (int idDepartamento){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaDepartamento);
            stmt.setInt(1, idDepartamento);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Departamento d = new Departamento();
                d.setNomeDepartamento(rs.getString("nomeDepartamento"));
                d.setLocalizacao(rs.getString("localizacao"));
                return d;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar departamento" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
}
