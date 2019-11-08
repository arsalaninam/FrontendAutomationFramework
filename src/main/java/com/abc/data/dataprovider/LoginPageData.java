package com.abc.data.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * A data provider class to provide test data for Login Page related test cases
 *
 * @author Arsalan Inam
 */
public class LoginPageData {

    @DataProvider
    public static Object[][] validLoginPageTitle() {
        return new Object[][]{
                {"Log in to omnius"}
        };
    }

    @DataProvider
    public static Object[][] validLoginUsernamePasswordWithPageTitle() {
        return new Object[][]{
                {"testuser", "testuser", "omni:us"}
        };
    }

    @DataProvider
    public static Object[][] invalidLoginUsernamePasswordWithFailMessage() {
        return new Object[][]{
                {"testuser", "testUser12", "Invalid username or password."}
        };
    }

    @DataProvider
    public static Object[][] caseSensitiveLoginUsernamePasswordWithFailMessage() {
        return new Object[][]{
                {"testuser", "tEstUseR", "Invalid username or password."}
        };
    }
}
