package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;


/**
 * Interfejs koji deklarise metoda za rad sa objektima klase AutoGuma
 * 
 * @author Mihailo Sljuka
 * @version 0.1
 */
public interface Radnja {

	/**
	 * Dodaje novu gumu na listu guma u radnju
	 * 
	 * @param a Guma kao instanca klase AutoGuma
	 * @throws java.lang.NullPointerException Ako je uneta guma null
	 * @throws java.lang.RuntimeException Ako guma vec postoji u radnji (listi guma)
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pronalazi i vraca listu guma (objekat klase AutoGuma)
	 * 
	 * @param markaModel Marka i model gume kao String
	 * @return Lista guma (instanca klase AutoGuma) koji imaju odgovarajucu marku i model
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Pronalazi i vraca listu svih guma (objekat klase AutoGuma) u radnji
	 * @return Lista svih guma (instanca klase AutoGuma) u radnji
	 */
	List<AutoGuma> vratiSveGume();
}