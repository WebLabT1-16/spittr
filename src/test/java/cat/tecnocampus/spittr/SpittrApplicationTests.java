package cat.tecnocampus.spittr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpittrApplication.class)
@WebAppConfiguration
public class SpittrApplicationTests {

	//@Test
	public void contextLoads() {
		assertTrue(true);
	}

}
