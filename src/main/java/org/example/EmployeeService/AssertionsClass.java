package EmployeeService;

import org.testng.Assert;

public class AssertionsClass {

    public void assertStatusCode(int statusCode, int i) {
        Assert.assertEquals(statusCode,i,"Statuscode different");
    }
}
