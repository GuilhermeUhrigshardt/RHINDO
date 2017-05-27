/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Endereco;
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
public class EnderecoDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private String buscarUf = "select sigla from UF order by idUf";
    
    public List<Endereco> buscarUfs() throws SQLException, ClassNotFoundException {
        List<Endereco> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarUf);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setUf(rs.getString("sigla"));
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Enderecos: " + ex.getMessage());
        } finally {
            stmt.close();
            rs.close();
            con.close();
        }
        return lista;
    }
}
