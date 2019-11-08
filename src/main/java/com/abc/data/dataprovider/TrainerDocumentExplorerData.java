package com.abc.data.dataprovider;

import org.testng.annotations.DataProvider;

public class TrainerDocumentExplorerData {

    @DataProvider
    public static Object[][] validUsernamePasswordAndPageHeadings() {
        return new Object[][]{
                {"testuser", "testuser", "Console", "Document explorer"}
        };
    }
}
