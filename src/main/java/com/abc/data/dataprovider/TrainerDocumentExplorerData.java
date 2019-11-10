package com.abc.data.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * A data provider class to provide test data for Trainer Document Explorer related test cases
 *
 * @author Arsalan Inam
 */
public class TrainerDocumentExplorerData {

    @DataProvider
    public static Object[][] validUsernamePasswordAndPageHeadings() {
        return new Object[][]{
                {"testuser", "testuser", "Console", "Document explorer"}
        };
    }
}
