/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cargo;
import Beans.Departamento;
import Beans.Endereco;
import Beans.Funcionario;
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
public class FuncionarioDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private String cadastrarEndereco = "insert into Funcionario (idEndereco, idCargo, idDepartamento, nomeFuncionario, cpf, rg, celular, email, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String buscarTodos = "select f.idFuncionario, f.nomeFuncionario, f.cpf, f.rg, f.celular, f.email, e.rua, e.numero, e.bairro, e.cep, e.cidade, u.sigla, d.nomeDepartamento, c.nomeCargo from Funcionario f inner join Endereco e on f.idEndereco = e.idEndereco inner join UF u on e.idUF = u.idUF inner join Departamento d on d.idDepartamento = f.idDepartamento inner join Cargo c on f.idCargo = c.idCargo order by f.idFuncionario";
    private String buscarPorNome = "select f.idFuncionario, f.nomeFuncionario, f.cpf, f.rg, f.celular, f.email, e.rua, e.numero, e.bairro, e.cep, e.cidade, u.sigla, d.nomeDepartamento, c.nomeCargo from Funcionario f inner join Endereco e on f.idEndereco = e.idEndereco inner join UF u on e.idUF = u.idUF inner join Departamento d on d.idDepartamento = f.idDepartamento inner join Cargo c on f.idCargo = c.idCargo where f.nomeFuncionario like ? order by f.idFuncionario";

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
    
    public List<Funcionario> buscarTodos() throws SQLException, ClassNotFoundException {
        List<Funcionario> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarTodos);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Departamento d = new Departamento();
                Cargo c = new Cargo();
                f.setIdFuncionario(rs.getInt("f.idFuncionario"));
                f.setNomeFuncionario(rs.getString("f.nomeFuncionario"));
                f.setCpf(rs.getString("f.cpf"));
                f.setRg(rs.getString("f.rg"));
                f.setCelular(rs.getString("f.celular"));
                f.setEmail(rs.getString("f.email"));
                e.setRua(rs.getString("e.rua"));
                e.setNumero(rs.getInt("e.numero"));
                e.setBairro(rs.getString("e.bairro"));
                e.setCep(rs.getString("e.cep"));
                e.setCidade(rs.getString("e.cidade"));
                e.setUf(rs.getString("u.sigla"));
                d.setNomeDepartamento(rs.getString("d.nomeDepartamento"));
                c.setNomeCargo(rs.getString("c.nomeCargo"));
                f.setCargo(c);
                f.setEndereco(e);
                f.setDepartamento(d);
                lista.add(f);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Cargos: " + ex.getMessage());
        } finally {
            stmt.close();
            con.close();
        }
        return lista;
    }
    
    public List<Funcionario> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        List<Funcionario> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscarPorNome);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                Endereco e = new Endereco();
                Departamento d = new Departamento();
                Cargo c = new Cargo();
                f.setIdFuncionario(rs.getInt("f.idFuncionario"));
                f.setNomeFuncionario(rs.getString("f.nomeFuncionario"));
                f.setCpf(rs.getString("f.cpf"));
                f.setRg(rs.getString("f.rg"));
                f.setCelular(rs.getString("f.celular"));
                f.setEmail(rs.getString("f.email"));
                e.setRua(rs.getString("e.rua"));
                e.setNumero(rs.getInt("e.numero"));
                e.setBairro(rs.getString("e.bairro"));
                e.setCep(rs.getString("e.cep"));
                e.setCidade(rs.getString("e.cidade"));
                e.setUf(rs.getString("u.sigla"));
                d.setNomeDepartamento(rs.getString("d.nomeDepartamento"));
                c.setNomeCargo(rs.getString("c.nomeCargo"));
                f.setCargo(c);
                f.setEndereco(e);
                f.setDepartamento(d);
                lista.add(f);
            }
            return lista;
        } catch (SQLException ex) {
            out.println("Erro ao listar Cargos: " + ex.getMessage());
        } finally {
            stmt.close();
            con.close();
        }
        return lista;
    }
}
