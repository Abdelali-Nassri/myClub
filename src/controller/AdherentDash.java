package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CrudAdherentImp;
import dao.CrudAdminImp;
import metier.Adherent;
import metier.Equipe;
import metier.Evenement;

/**
 * Servlet implementation class GerantDash
 */

public class AdherentDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrudAdherentImp db =new CrudAdherentImp();
	CrudAdminImp db2 =new CrudAdminImp() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdherentDash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login").equals("yes")) {
		
			
	
			

		
		ArrayList<Evenement> evenements;
		ArrayList<Evenement> evenements2=new ArrayList<Evenement>();
		try {Adherent adh = null;
			evenements = db.getEvenement();
			
			for (Adherent ad : db2.getMembres()) {
				if(ad.getEmail().equals((String)session.getAttribute("email"))) {adh=ad;}
			}
			for (Evenement evenement : evenements) {
				if(evenement.getEquipe().equals(adh.getEquipe())) {evenements2.add(evenement);}
			}
			session.setAttribute("evenements", evenements2);
			session.setAttribute("profil", adh);
			getServletContext().getRequestDispatcher("/adherentDash.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
		
		// TODO Auto-generated method stub
			
	}

}
