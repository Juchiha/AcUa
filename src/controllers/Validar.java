package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AspiranteDAO;
import DAO.DbConnection;
import models.Aspirante;

/**
 * Servlet implementation class Validar
 */
@WebServlet(name = "datosAspirante", description = "Obtener los datos de los Aspirantes registrados", urlPatterns = { "/datosAspirante" })
public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Validar() {
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
		DbConnection db = new DbConnection();
		AspiranteDAO aspiranteDAO = new AspiranteDAO(db);
		System.out.println("Soy Batman ::> parametro ::> "+ request.getParameter("getDataAspirante"));
		Aspirante aspirante = aspiranteDAO.getDatosAspirante(request.getParameter("getDataAspirante"));
		PrintWriter pw = response.getWriter();		
		db.desconectar();
		response.setContentType("application/json");
		if(aspirante != null) {
			pw.print(aspirante.toString());
			System.out.println("Soy Batman ::> Resultado ::> "+ aspirante.toString());
		}else {
			pw.print("{\"code\":\"0\", \"message\":\"Identificacion no registrada!\"}");
			System.out.println("Soy Batman ::> Resultado ::> false");
		}
	}

}
