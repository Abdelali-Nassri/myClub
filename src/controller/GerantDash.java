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

import dao.CrudAdminImp;
import metier.Adherent;
import metier.Equipe;
import metier.Evenement;

/**
 * Servlet implementation class GerantDash
 */

public class GerantDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrudAdminImp db =new CrudAdminImp();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerantDash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login").equals("yes")) {
		try {
		

		ArrayList<Equipe> equipes = db.getEquipes();
		ArrayList<Evenement> evenements = db.getEvenement();
		ArrayList<Adherent> membres = db.getMembres();
		ArrayList<Adherent> coachs = new ArrayList<Adherent>();
		for (Adherent adherent : membres) {
			if(adherent.getRole().equals("Coach")) {coachs.add(adherent);}
		}
		
		session.setAttribute("equipes", equipes);
		session.setAttribute("evenements", evenements);
		session.setAttribute("coachs", coachs);
		session.setAttribute("membres", membres);
		
		if(request.getAttribute("adminJsp").equals("Dash")) {
		request.getRequestDispatcher("/adminDash.jsp").forward(request, response);}
		
		if(request.getAttribute("adminJsp").equals("Dash2")) {
			request.getRequestDispatcher("/adminDash2.jsp").forward(request, response);}
		
		if(request.getAttribute("adminJsp").equals("Dash3")) {
			request.getRequestDispatcher("/adminDash3.jsp").forward(request, response);}
		
		if(request.getAttribute("adminJsp").equals("quit")) {
			session.setAttribute("login", "no");
			request.getRequestDispatcher("/index.html").forward(request, response);}
		
		
		request.getRequestDispatcher("/adminDash.jsp").include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		String btn=request.getParameter("btn");
		if(btn.equals("addEq")) {
		Equipe eq =new Equipe(request.getParameter("nom"), request.getParameter("sport"), request.getParameter("genre"), request.getParameter("tranche"), request.getParameter("niveau"));
		
		
		try {
			db.ajouterEquipe(eq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		if(btn.equals("addMe")) {
			Adherent eq =new Adherent(request.getParameter("email"), request.getParameter("nom"),request.getParameter("role"),request.getParameter("equipe"), Integer.parseInt(request.getParameter("age")), false, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			
			
			try {
				db.ajouterMembre(eq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		if(btn.equals("delEq")) {
			try {
				db.supprimerEquipe(request.getParameter("nomEq"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		if(btn.equals("seaEq")) {
			try {
				ArrayList<Equipe> equipesS =db.chercherEquipe(request.getParameter("search"));
				HttpSession session = request.getSession();
				session.setAttribute("equipes", equipesS);
				request.getRequestDispatcher("/adminDash.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		
		if(btn.equals("membres")) {
			
			request.setAttribute("adminJsp", "Dash2");
			doGet(request, response);
		}
		if(btn.equals("evenements")) {
			
			request.setAttribute("adminJsp", "Dash3");
			doGet(request, response);
		}
		if(btn.equals("equipes")) {
			request.setAttribute("adminJsp", "Dash");
		}
		
		if(btn.equals("quit")) {
			request.setAttribute("adminJsp", "quit");
			doGet(request, response);
		
		}
		request.setAttribute("adminJsp", "Dash");
		doGet(request, response);
		
		// TODO Auto-generated method stub
			
	}

}
