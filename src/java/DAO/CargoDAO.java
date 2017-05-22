/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class CargoDAO {
    private String stmtBuscaCargo = "SELECT nomeCargo, salario, requisitos, cargaMinima, descontoImpostos FROM cargo WHERE idCargo = ?";
    
    public Cargo lerCargo (int idCargo){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaCargo);
            stmt.setInt(1, idCargo);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Cargo c = new Cargo();
                c.setNomeCargo(rs.getString("nome"));
                c.setSalario(rs.getFloat("salario"));
                c.setRequisitos(rs.getString("requisitos"));
                c.setCargaMinima(rs.getInt("cargaMinima"));
                c.setDescontoImpostos(rs.getFloat("descontoImpostos"));
                return c;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar usuario " + ex.getMessage());
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
