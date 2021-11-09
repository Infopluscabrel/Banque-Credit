package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculMetier {
	
	// classe a tester
	private CreditMetierImpl metier ; 

	@Before
	public void setUp() throws Exception {
		
		// instanciation de la classe
		metier = new CreditMetierImpl() ;
	}

	@Test
	public void testCalculerMensualiteCredit() {
		// test proprement dit  
		
				double capital  = 200000;
				int duree = 240 ;
				double taux = 4.5 ;

				double resultatAttendu =1265.2987 ; 
				
				
			double resultatCalculer =metier.calculerMensualiteCredit(capital, taux, duree) ; 
					
			
			
			assertEquals(resultatAttendu, resultatCalculer, 0.0001);
			//assertTrue(resultatAttendu==resultatCalculer) ; 
			// assertTrue(condition)
			// mvn test  
			// la commande pour executer tous les test Unitaires
	}

}
