package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.gorest.co.in.CreateUser;
import com.qaprosoft.carina.demo.api.gorest.co.in.DeleteUser;
import com.qaprosoft.carina.demo.api.gorest.co.in.GetUser;
import org.testng.annotations.Test;

public class ApiCreateUserTest extends AbstractTest {


    @Test(description = "JIRA#DEMO-0001")
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() {
        CreateUser createUser = new CreateUser();
        createUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        createUser.callAPI();
        createUser.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0002")
    @MethodOwner(owner = "qpsdemo")
    public void testGetUser() {
        GetUser getUser = new GetUser();
        getUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUser.callAPI();
        getUser.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "qpsdemo")
    public void testDeleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUser.callAPI();
        deleteUser.validateResponse();
    }
}
