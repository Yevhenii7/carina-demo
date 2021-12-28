package com.qaprosoft.carina.demo.api_github;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.github.PostCreateReactionForIssueMethod;

public class ReactionTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-1")
    @MethodOwner(owner = "ykolchyba")
    public void createReactionInIssue() {
        PostCreateReactionForIssueMethod reactionIssue = new PostCreateReactionForIssueMethod();
        reactionIssue.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        reactionIssue.callAPI();
        reactionIssue.validateResponse();
    }
}
