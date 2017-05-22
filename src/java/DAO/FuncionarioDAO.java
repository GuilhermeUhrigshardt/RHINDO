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
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    String buscarPorNome = "select idFuncionario, from Funcionario where nomeFuncionario like ? order by idFuncionario";
    
    String buscarTodos = "select * from empresa order by id_empresa";
    
    
}
