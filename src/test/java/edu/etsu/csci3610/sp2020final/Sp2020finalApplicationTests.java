package edu.etsu.csci3610.sp2020final;

import edu.etsu.csci3610.sp2020final.configurations.DatabaseInterchange;
import edu.etsu.csci3610.sp2020final.controllers.FreeLizardController;
import edu.etsu.csci3610.sp2020final.models.Account;
import edu.etsu.csci3610.sp2020final.models.FreeLizard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

@SpringBootTest
class Sp2020finalApplicationTests
{
	@Autowired
	DatabaseInterchange databaseInterchange;

	@Test
	void testGetAccountByLogin()
	{
		Account validAccount = databaseInterchange.GetAccountByLogin("admin@lol.com", "admin");	// First, test a valid user using the admin account
		Assert.notNull(validAccount, "Valid account is not null.");								// Which should be not null when using the correct username and password

		Account invalidAccount = databaseInterchange.GetAccountByLogin("", "' OR '1' = '1");	// In the original version, this would return not null, because it always returns the admin
		Assert.isNull(invalidAccount, "Invalid account is null.");								// But this should return null given that SQL injection should no longer work
	}

	@Test
	void testFreeLizard()
	{
		// Test the model for the free lizard sign up
		FreeLizard freeLizard = new FreeLizard();
		freeLizard.setName("Test");

		Assert.isTrue(freeLizard.getName() == "Test", "Name: " + freeLizard.getName());

		Assert.hasText(freeLizard.toString(), freeLizard.toString());
	}
}