package auto_radnja;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import auto_radnja.gume.AutoGuma;

class VulkanizerskaRadnjaTest extends RadnjaTest {

	AutoGuma a;
	@BeforeEach
	void setUp() throws Exception {
		rad = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		rad = null;
	}


}
