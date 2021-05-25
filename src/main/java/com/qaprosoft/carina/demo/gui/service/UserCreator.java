package com.qaprosoft.carina.demo.gui.service;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.model.User;

public class UserCreator implements IDriverPool {

    public User getUser() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("email"));
        user.setPassword(R.TESTDATA.getDecrypted("password"));
        return user;
    }

    public User getUserWithInvalidEmail() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("invalid_email"));
        user.setPassword(R.TESTDATA.get("password"));
        return user;
    }

    public User getUserWithInvalidPassword() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("email"));
        user.setPassword(R.TESTDATA.get("invalid_password"));
        return user;
    }
}
