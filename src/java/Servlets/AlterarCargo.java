/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cargo;
import DAO.CargoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
@WebServlet(name = "AlterarCargo", urlPatterns = {"/AlterarCargo"})
public class AlterarCargo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        if (session.getAttribute("funcionario") == null) {
            request.setAttribute("msg", "Acesso negado!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }
        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = new Cargo();
        //instancia cargo para popular campos
        if (request.getParameter("car") != null) {
            int id = Integer.valueOf(request.getParameter("car"));            
            cargo = cargoDAO.buscarPorId(id);
            request.setAttribute("cargo", cargo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterar_cargo.jsp");
            rd.forward(request, response);
        }
        //realiza alteracao
        else {
            cargo.setIdCargo(Integer.valueOf(request.getParameter("Id")));
            cargo.setNomeCargo(request.getParameter("Nome"));
            cargo.setSalario(Float.valueOf(request.getParameter("Salario")));
            cargo.setRequisitos(request.getParameter("Requisitos"));
            cargo.setCargaMinima(Integer.valueOf(request.getParameter("CargaMinima")));
            cargo.setDescontoImpostos(Integer.valueOf(request.getParameter("DescontoImpostos")));
            cargoDAO.atualizarCargo(cargo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/manter_cargos.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarCargo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarCargo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}