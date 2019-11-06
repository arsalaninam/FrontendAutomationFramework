package com.abc.data.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * A data provider class to provide test data for Console Page related test cases
 *
 * @author Arsalan Inam
 */
public class ConsolePageData {

    @DataProvider
    public static Object[][] validLoginUsernamePasswordAndPageTitle() {
        return new Object[][]{
                {"testuser", "testuser", "omni:us", "omni:us"}
        };
    }
}
