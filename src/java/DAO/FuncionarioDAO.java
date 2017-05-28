/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Funcionario;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class FuncionarioDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private String cadastrarEndereco = "insert into Funcionario (idEndereco, idCargo, idDepartamento, nomeFuncionario, cpf, rg, celular, email, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(cadastrarEndereco);
            stmt.setInt(1, funcionario.getEndereco().getIdEndereco());
            stmt.setInt(2, funcionario.getCargo().getIdCargo());
            stmt.setInt(3, funcionario.getDepartamento().getIdDepartamento());
            stmt.setString(4, funcionario.getNomeFuncionario());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getRg());
            stmt.setString(7, funcionario.getCelular());
            stmt.setString(8, funcionario.getEmail());
            stmt.setString(9, funcionario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            out.println("Erro ao cadastrar Funcionario: " + ex.getMessage());
        } finally {
            stmt.close();
            con.close();
        }
    }
}
