package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {

  HomePage homePage = new HomePage();
  LoginPage loginPage = new LoginPage();


  @Test
  public void verifyUserShouldNavigateToLoginPage(){
      homePage.clickOnLoginLink();
      String expectedMessage = "Welcome, Please Sign In!";
      String actualMessage = loginPage.getWelcomeText();
      Assert.assertEquals(expectedMessage,actualMessage,"you are not on login page");
  }

  @Test
    public void verifyErrorMessageWithInvalidCredential(){
      homePage.clickOnLoginLink();
      loginPage.enterEmail("nop@gmail.com");
      loginPage.enterPassword("Hello123");
      loginPage.clickOnLoginButton();
      String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
              + "No customer account found";
      String actualErrorMessage =loginPage.getErrorMessage();
      Assert.assertEquals(expectedErrorMessage, actualErrorMessage,"Error message not displayed");
  }

}

