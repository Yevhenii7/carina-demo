package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.continents.PostContinentMethod;
import com.qaprosoft.carina.demo.api.gorest.co.in.CreateUser;
import com.qaprosoft.carina.demo.api.gorest.co.in.DeleteUser;
import com.qaprosoft.carina.demo.api.gorest.co.in.GetUser;
import org.testng.annotations.Test;

public class ApiCreateContinentsTest extends AbstractTest {


    @Test(description = "JIRA#DEMO-0001")
    @MethodOwner(owner = "qpsdemo")
    public void testGetContinents() {
        PostContinentMethod continent = new PostContinentMethod();
        continent.expectResponseStatus(HttpResponseStatusType.OK_200);
        continent.callAPI();
        continent.validateResponse();
    }
}
