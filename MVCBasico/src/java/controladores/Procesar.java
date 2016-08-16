/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.carros;

/**
 *
 * @author Edgar ROdriguez Arias
 */
public class Procesar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Llamado de los valores desde la vista
        String codigo = request.getParameter("txtCod");
        String desc = request.getParameter("txtDesc");
        String valor = request.getParameter("txtValor");
       
        //Validaciones basicas
        if(codigo.equals("") || desc.equals("") || valor.equals("")){
            request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
        }
        else{
            int val = 0;
            try{
                val = Integer.parseInt(valor); //parseo para pasar valor string a entero
            }
            catch(NumberFormatException r){
                request.getRequestDispatcher("errorvalor.jsp").forward(request, response);
            }
            carros c1 = new carros(codigo, desc, val);//Creacion del objeto carros de la clase carros
            request.getSession().setAttribute("carro", c1);
            request.getRequestDispatcher("mostrarcarros.jsp").forward(request, response);//Mostrar pagina de lista de carros
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
        processRequest(request, response);
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
        processRequest(request, response);
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
