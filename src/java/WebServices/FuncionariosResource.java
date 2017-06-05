/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Beans.Funcionario;
import DAO.FuncionarioDAO;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author guilh
 */
@Path("funcionarios")
public class FuncionariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionariosResource
     */
    public FuncionariosResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.FuncionariosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/login/{email}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario buscaLogin(@PathParam("email") String email, @PathParam("senha") String senha) throws SQLException, ClassNotFoundException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();
        funcionario = funcionarioDAO.buscarLogin(email, senha);
        return funcionario;
    }

    /**
     * PUT method for updating or creating an instance of FuncionariosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
