/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class FuncionarioDAO {
    private String stmtBuscaFuncionario = "SELECT nomeFuncionario, cpf, rg, celular, email FROM funcionario WHERE nome = ?";
    
    public Funcionario lerFuncionario (String nomeFuncionario){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaFuncionario);
            stmt.setString(1, nomeFuncionario);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNomeFuncionario(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setCelular(rs.getString("celular"));
                f.setEmail(rs.getString("email"));
                return f;
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
