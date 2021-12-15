package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.mail.MessagingException;
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
import metier.Mail;

/**
 * Servlet implementation class GerantDash
 */

public class GerantDash3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrudAdminImp db =new CrudAdminImp();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerantDash3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Equipe> equipes = db.getEquipes();
			ArrayList<Evenement> evenements = db.getEvenement();
			ArrayList<Adherent> membres = db.getMembres();
			ArrayList<Adherent> coachs = new ArrayList<Adherent>();
		
		
		HttpSession session=request.getSession();
		session.setAttribute("equipes", equipes);
		session.setAttribute("evenements", evenements);
		session.setAttribute("coachs", coachs);
		session.setAttribute("membres", membres);
		
		if(request.getParameter("btn").equals("disMe")) {
		Adherent profil=null;
		String email = request.getParameter("emailpr");
		for (Adherent adherent : membres) {
			if(adherent.getEmail().equals(email)) {profil=adherent;}
			
		}
		session.setAttribute("profil", profil);
		request.getRequestDispatcher("/adminDashMembre.jsp").forward(request, response);}
		else request.getRequestDispatcher("/adminDash3.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		String btn=request.getParameter("btn");
		
		
		if(btn.equals("addEv")) {
			Evenement eq =new Evenement(java.sql.Date.valueOf(request.getParameter("date")), request.getParameter("debut"),request.getParameter("fin"),request.getParameter("equipe"));
			
			
			try {
				
				
				db.ajouterEvenement(eq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		
		if(btn.equals("delMe")) {
			try {
				Evenement eq =new Evenement(java.sql.Date.valueOf(request.getParameter("date")), request.getParameter("debut"),request.getParameter("fin"),request.getParameter("equipe"));

				db.supprimerEvenement(eq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		if(btn.equals("seaEv")) {
			try {
				
				String date=request.getParameter("searched");
				System.out.println(date);
				ArrayList<Evenement> evenements =db.chercherEvenement(date);
				HttpSession session = request.getSession();
				session.setAttribute("evenements", evenements);
				request.getRequestDispatcher("/adminDash3.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		doGet(request, response);
		
		// TODO Auto-generated method stub
			
	}

}
