package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.graphql.GetGitHubGraphQLMethod;
import com.qaprosoft.carina.demo.api.graphql.PostGitHubGraphQLMethod;
import org.testng.annotations.Test;

public class ApiContentTest extends AbstractTest {


    @Test(description = "JIRA#DEMO-1")
    @MethodOwner(owner = "qpsdemo")
    public void testGetRepo() {
        GetGitHubGraphQLMethod apiRepo = new GetGitHubGraphQLMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }

    @Test(description = "JIRA#DEMO-2")
    @MethodOwner(owner = "qpsdemo")
    public void testAddContent() {
        PostGitHubGraphQLMethod apiRepo = new PostGitHubGraphQLMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }
}
