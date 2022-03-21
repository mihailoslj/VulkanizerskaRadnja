package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.*;

class AutoGumaTest {
	
	AutoGuma a;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	@DisplayName("Testira da li je objekat inicijalizovan")
	void testAutoGuma() {
		a = new AutoGuma();
		
		assertNotNull(a);
	}

	@Test
	@DisplayName("Testira da li je objekat pravilno inicijalizovan")
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("Micheline CrossClimate® 2", 15, 250, 70);
		
		assertNotNull(a);
		assertEquals("Micheline CrossClimate® 2", a.getMarkaModel());
		assertEquals(15, a.getPrecnik());
		assertEquals(250, a.getSirina());
		assertEquals(70, a.getVisina());
	}

	@Test
	@DisplayName("Testira ako je normalan unos za markaModel")
	void testSetMarkaModel() {
		a.setMarkaModel("Micheline CrossClimate® 2 Tires");
		
		assertEquals("Micheline CrossClimate® 2 Tires", a.getMarkaModel());
	}
	
	@Test
	@DisplayName("Testira ako je unet null za markaModel")
	void testSetMarkaModelNull() {
		
		assertThrows(java.lang.NullPointerException.class, 
				() -> a.setMarkaModel(null));
	}
	
	@Test
	@DisplayName("Testira ako je unet String manje duzine od 3 za markaModel")
	void testSetMarkaModelKratakString() {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setMarkaModel("M"));
	}

	@Test
	@DisplayName("Testira za normalan unos za precnik")
	void testSetPrecnik() {
		a.setPrecnik(15);
		assertEquals(15, a.getPrecnik());
	}
	@ParameterizedTest
	@CsvSource({
		"10",
		"30",
		"-1",
	})
	@DisplayName("Testira za unos koji je van opsega za precnik")
	void testSetPrecnikVanOpsega(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setPrecnik(precnik));
	}
	

	@Test
	@DisplayName("Testira za normalan unos za sirinu")
	void testSetSirina() {
		
		a.setSirina(150);
		assertEquals(150, a.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"120",
		"400",
		"-1",
	})
	@DisplayName("Testira za unos van opsega za sirinu")
	void testSetSirinaVanOpsega(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setSirina(sirina));
	}

	@Test
	@DisplayName("Testira za normalan unos za visinu")
	void testSetVisina() {
		a.setVisina(50);
		assertEquals(50, a.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"20",
		"100",
		"-1",
	})
	@DisplayName("Testira za unos van opsega za visinu")
	void testSetVisinaVanOpsega(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> a.setVisina(visina));
	}

	@Test
	void testToString() {
		a.setMarkaModel("Micheline CrossClimate® 2");
		a.setPrecnik(20);
		a.setSirina(200);
		a.setVisina(70);
		
		String st = a.toString();
		
		assertTrue(st.contains("Micheline CrossClimate® 2"));
		assertTrue(st.contains("20"));
		assertTrue(st.contains("200"));
		assertTrue(st.contains("70"));
	}

	@ParameterizedTest
	@CsvSource({
		"Micheline CrossClimate® 2, 20, 200, 70, Micheline CrossClimate® 2, 20, 200, 70, true", 
		"Micheline CrossClimate® 2, 20, 200, 70, Micheline CrossClimate® 3, 20, 200, 70, false", 
		"Micheline CrossClimate® 2, 20, 250, 70, Micheline CrossClimate® 2, 20, 200, 70, false", 
		"Micheline CrossClimate® 2, 20, 200, 60, Micheline CrossClimate® 2, 20, 200, 70, false", 
		"Micheline CrossClimate® 2, 15, 200, 70, Micheline CrossClimate® 2, 20, 200, 70, false", 
		
	})
	void testEqualsObject(String mm1, int precnik1, int sirina1, int visina1,
			String mm2, int precnik2, int sirina2, int visina2, boolean eq) {
		a.setMarkaModel(mm1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel(mm2);
		b.setPrecnik(precnik2);
		b.setSirina(sirina2);
		b.setVisina(visina2);
		
		assertEquals(eq, a.equals(b));
	}

}
