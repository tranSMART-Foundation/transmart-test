package tests
import geb.junit4.GebReportingTest

import org.junit.Ignore
import org.junit.Test

import pages.Constants
import pages.LoginPage
import pages.LoginFailedPage

class LoginTests extends GebReportingTest {

    @Test
    void testFailedLogin() {
		if (!Constants.AUTO_LOGIN_ENABLED) {
	        to LoginPage
	
	        usernameField.value Constants.BAD_USERNAME
	        passwordField.value Constants.BAD_PASSWORD
	        loginButton.click()
	
	        assert at(LoginFailedPage)
		} else {
			println("Auto login enabled: test skipped with assert true - testFailedLogin")
			assert true
		}
    }

    @Test
    void testSuccessfulLogin() {
		if (!Constants.AUTO_LOGIN_ENABLED) {
	        to LoginPage
			println("Page = " + page);
			
	        usernameField.value Constants.GOOD_USERNAME
	        passwordField.value Constants.GOOD_PASSWORD
	        loginButton.click()
			
	        assert at(Constants.LANDING_PAGE.class)
		} else {
			println("Auto login enabled: test skipped with assert true - testSuccessfulLogin")
			assert true
		}
    }
}
