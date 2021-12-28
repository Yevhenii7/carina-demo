package com.qaprosoft.carina.demo.api_github;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.github.GetIssueMethod;
import com.qaprosoft.carina.demo.api.github.PatchIssueUpdateMethod;
import com.qaprosoft.carina.demo.api.github.PostCreateCommentIssueMethod;
import com.qaprosoft.carina.demo.api.github.PostIssueCreateMethod;

public class IssueTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-1")
    @MethodOwner(owner = "ykolchiba")
    public void createIssueTest() {
        PostIssueCreateMethod apiRepo = new PostIssueCreateMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }

    @Test(description = "JIRA#DEMO-2")
    @MethodOwner(owner = "ykolchiba")
    public void updateIssueTest() {
        PatchIssueUpdateMethod apiPatchUpdateIssue = new PatchIssueUpdateMethod();
        apiPatchUpdateIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiPatchUpdateIssue.callAPI();
        apiPatchUpdateIssue.validateResponse();
    }

    @Test(description = "JIRA#DEMO-3")
    @MethodOwner(owner = "ykolchiba")
    public void getIssueTest() {
        GetIssueMethod getIssueMethod = new GetIssueMethod();
        getIssueMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getIssueMethod.callAPI();
        getIssueMethod.validateResponse();
    }

    @Test(description = "JIRA#DEMO-4")
    @MethodOwner(owner = "ykolchiba")
    public void addCommentToIssue() {
        PostCreateCommentIssueMethod apiAddComment = new PostCreateCommentIssueMethod();
        apiAddComment.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiAddComment.callAPI();
        apiAddComment.validateResponse();
    }
}
