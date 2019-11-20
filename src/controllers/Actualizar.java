package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import DAO.AspiranteDAO;
import DAO.DbConnection;
import models.Aspirante;

/**
 * Servlet implementation class Actualizar
 */
@WebServlet(name = "updateInformacion", urlPatterns = { "/updateInformacion" })
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Que dijiste corone? No señor, todavia te falta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("txtIdentificacion") != null && !request.getParameter("txtIdentificacion").equals("")) {
			DbConnection db = new DbConnection();
			AspiranteDAO aspiranteDAO = new AspiranteDAO(db);
			Aspirante aspirante = new Aspirante();
			aspirante.setStrNumeroDocumento(request.getParameter("txtIdentificacion"));
			aspirante.setStrNuevoAc(request.getParameter("txtAC"));
			
			boolean resultado = aspiranteDAO.updateInformacionAspirante(aspirante);
			PrintWriter pw = response.getWriter();		
			db.desconectar();
			
			response.setContentType("application/json");
			if(resultado == true) {
				pw.print("{\"code\":\"1\", \"message\":\"AC actualizado!\"}");
				System.out.println("Soy Batman ::> Resultado ::> true");
			}else {
				pw.print("{\"code\":\"0\", \"message\":\"AC no Actualizado!\"}");
				System.out.println("Soy Batman ::> Resultado ::> false");
			}
			
		}
		
	}

}
