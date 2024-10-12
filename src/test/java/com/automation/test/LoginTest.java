package com.automation.test;

import com.automation.util.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends BaseTest{
    @Test(dataProvider = "getValidCredentials")
    public void validateLogin(String username, String password){
        loginPage.openWebsite();
        loginPage.doLogin(username, password);
    }
    @DataProvider
    public Object[][] getValidCredentials() {
        ExcelUtils excelUtils = new ExcelUtils("Credentials.xlsx", "ValidData");
        List<List<String>> tableData = excelUtils.getData();
        Object[][] data = new Object[tableData.size()][tableData.get(0).size()];

        for (int i = 0; i < tableData.size(); i++) {
            List<String> row = tableData.get(i);
            for (int j = 0; j < row.size(); j++) {
                data[i][j] = tableData.get(i).get(j);
            }
        }

        return data;
    }
}
