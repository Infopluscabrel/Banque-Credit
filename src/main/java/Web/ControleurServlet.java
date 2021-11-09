package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
// declaration de la servlet`

// @WebServlet(name="cs" , urlPatterns= {"/controleur" ,"*.do"})

public class ControleurServlet extends HttpServlet {
	private ICreditMetier metier ; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetierImpl() ;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// methode get 
		
		// initialison la classe Model 
		request.setAttribute("creditModel", new CreditModel());
		// forward vers la vue 
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response); 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// methode post , recuperation des donnees de requetes 
		double montant = Double.parseDouble(request.getParameter("montant")) ;
		double taux = Double.parseDouble(request.getParameter("taux")) ;
		int duree = Integer.parseInt(request.getParameter("duree")) ;
		
		// validation des donnees des envoyes 
		
		// stocke les donnees dans le model
		CreditModel model = new CreditModel() ;
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		// faire le calcul , appel couche metier 
	double res = metier.calculerMensualiteCredit(montant, taux, duree) ; 
	
	// stocker le resultat dans le model 
	model.setMensualite(res);
	
	// stocker le model dans l'objet request pour le transmettre  
		request.setAttribute("creditModel", model);
		// faire un forward vers la vue jsp 
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	
	}
	
}
