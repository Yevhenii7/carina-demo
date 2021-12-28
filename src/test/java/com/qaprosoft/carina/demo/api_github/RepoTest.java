package com.qaprosoft.carina.demo.api_github;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.github.DeleteRepoMethod;
import com.qaprosoft.carina.demo.api.github.GetRepoMethod;
import com.qaprosoft.carina.demo.api.github.PatchUpdateRepoMethod;
import com.qaprosoft.carina.demo.api.github.PostCreateRepoMethod;


public class RepoTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-1")
    @MethodOwner(owner = "ykolchiba")
    public void createRepoTest() {
        PostCreateRepoMethod apiRepo = new PostCreateRepoMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }

    @Test(description = "JIRA#DEMO-2")
    @MethodOwner(owner = "ykolchiba")
    public void updateRepoTest() {
        PatchUpdateRepoMethod apiPatchUpdateIssue = new PatchUpdateRepoMethod();
        apiPatchUpdateIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiPatchUpdateIssue.callAPI();
        apiPatchUpdateIssue.validateResponse();
    }

    @Test(description = "JIRA#DEMO-3")
    @MethodOwner(owner = "ykolchiba")
    public void getRepoTest() {
        GetRepoMethod apiGetRepo = new GetRepoMethod();
        apiGetRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiGetRepo.callAPI();
        apiGetRepo.validateResponse();
    }

    @Test(description = "JIRA#DEMO-4")
    @MethodOwner(owner = "ykolchiba")
    public void deleteRepoTest() {
        DeleteRepoMethod apiDeleteRepo = new DeleteRepoMethod();
        apiDeleteRepo.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        int response = apiDeleteRepo.callAPI().statusCode();
        Assert.assertEquals(response,204,"response are not valid");
    }
}
