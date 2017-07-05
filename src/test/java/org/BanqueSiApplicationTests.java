package org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import anasnash.banque.BanqueSiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BanqueSiApplication.class)
@WebAppConfiguration
public class BanqueSiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
