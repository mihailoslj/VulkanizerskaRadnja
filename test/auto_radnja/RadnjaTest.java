package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja rad;
	
	@Test
	void testDodajGumu() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Micheline 1");
		
		rad.dodajGumu(a1);
		
		assertEquals(a1, rad.vratiSveGume().get(0));
		assertEquals(1, rad.vratiSveGume().size());
	}
	
	@Test
	void testDodajGumuNull() {
		
		NullPointerException n = assertThrows(java.lang.NullPointerException.class,
				() -> rad.dodajGumu(null));	
		
		assertEquals("Guma ne sme biti null", n.getMessage());
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a1 = new AutoGuma();
		AutoGuma a2 = new AutoGuma();
		
		a1.setMarkaModel("Micheline 1");
		a2.setMarkaModel("Micheline 1");
		
		rad.dodajGumu(a1);
		
		RuntimeException run = assertThrows(java.lang.RuntimeException.class,
				() -> rad.dodajGumu(a2));	
		
		assertEquals("Guma vec postoji", run.getMessage());
	}
	
	@Test
	void testPronadjiGumu() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Micheline 1");
		
		rad.dodajGumu(a1);
		
		List<AutoGuma> pom = rad.pronadjiGumu(a1.getMarkaModel());
		assertTrue(pom.contains(a1));
	}
	
	@Test
	void testPronadjiGumuNull() {
		AutoGuma a1 = new AutoGuma();
		
		rad.dodajGumu(a1);
		
		assertEquals(null, rad.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNePronalazi() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Micheline 1");
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Micheline 2");
		
		rad.dodajGumu(a1);
		
		assertEquals(0, rad.pronadjiGumu(a2.getMarkaModel()).size());
	}
	
	@Test
	void testPronadjiGumuViseGuma() {
		AutoGuma a1 = new AutoGuma("Micheline 1", 20, 150, 50);
		AutoGuma a2 = new AutoGuma("Micheline 1", 17, 175, 80);
		AutoGuma a3 = new AutoGuma("Micheline 1", 16, 160, 75);
		
		rad.dodajGumu(a1);
		rad.dodajGumu(a2);
		rad.dodajGumu(a3);
		
		List<AutoGuma> pom = rad.pronadjiGumu("Micheline 1");
		
		assertEquals(3, pom.size());
		assertTrue(pom.contains(a1));
		assertTrue(pom.contains(a2));
		assertTrue(pom.contains(a3));
		
	}

	@Test
	void testVratiSveGume() {
		assertEquals(0, rad.vratiSveGume().size());
		
		AutoGuma a1 = new AutoGuma("Micheline 1", 20, 150, 50);
		AutoGuma a2 = new AutoGuma("Micheline 1", 17, 175, 80);
		AutoGuma a3 = new AutoGuma("Micheline 1", 16, 160, 75);
		
		rad.dodajGumu(a1);
		rad.dodajGumu(a2);
		rad.dodajGumu(a3);
		
		assertEquals(3, rad.vratiSveGume().size());
	}

}
