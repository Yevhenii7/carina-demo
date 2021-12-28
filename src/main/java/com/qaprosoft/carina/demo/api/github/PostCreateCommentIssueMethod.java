/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCreateCommentIssueMethod extends AbstractApiMethodV2 {

    public PostCreateCommentIssueMethod() {
        super("api.github/post_create_comment_to_issue/rq.json", "api.github/post_create_comment_to_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header("Authorization", "Bearer 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");

    }
}
