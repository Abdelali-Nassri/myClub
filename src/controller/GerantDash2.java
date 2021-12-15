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
import metier.Mail;

/**
 * Servlet implementation class GerantDash
 */

public class GerantDash2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrudAdminImp db =new CrudAdminImp();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerantDash2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		ArrayList<Equipe> equipes = db.getEquipes();
		ArrayList<Adherent> membres = db.getMembres();
		
		
		HttpSession session=request.getSession();
		session.setAttribute("equipes", equipes);
		session.setAttribute("membres", membres);
		
		if(request.getParameter("btn").equals("disMe")) {
		Adherent profil=null;
		String email = request.getParameter("emailpr");
		for (Adherent adherent : membres) {
			if(adherent.getEmail().equals(email)) {profil=adherent;}
			
		}
		session.setAttribute("profil", profil);
		request.getRequestDispatcher("/adminDashMembre.jsp").forward(request, response);}
		else request.getRequestDispatcher("/adminDash2.jsp").forward(request, response);
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
		
		
		if(btn.equals("addMe")) {
			Adherent eq =new Adherent(request.getParameter("email"), request.getParameter("nom"),request.getParameter("role"),request.getParameter("equipe"), Integer.parseInt(request.getParameter("age")), false, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			
			
			try {
				
				int code = (int)(Math.random() * 11111111-98765412) + 11111111;
				if(code<0) {code=code*-1;}
				eq.setCode(code);
				db.ajouterMembre(eq);
				Mail.sendEmail(eq.getEmail(), eq.getNom(),code);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		if(btn.equals("updMe")) {
			Adherent eq =new Adherent(request.getParameter("email"), request.getParameter("nom"),request.getParameter("role"),request.getParameter("equipe"), Integer.parseInt(request.getParameter("age")),Boolean.getBoolean(request.getParameter("confirmer")), Date.valueOf(request.getParameter("date")));
			
			try {
				db.uppdateMembre(eq,request.getParameter("exequipe"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		if(btn.equals("delMe")) {
			try {
				db.supprimerMembre(request.getParameter("emaildel"),request.getParameter("roledel"),request.getParameter("equipedel"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		if(btn.equals("seaMe")) {
			try {
				ArrayList<Adherent> membresS =db.chercherMembre(request.getParameter("searchm"));
				HttpSession session = request.getSession();
				session.setAttribute("membres", membresS);
				request.getRequestDispatcher("/adminDash2.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
		doGet(request, response);
		
		// TODO Auto-generated method stub
			
	}

}
