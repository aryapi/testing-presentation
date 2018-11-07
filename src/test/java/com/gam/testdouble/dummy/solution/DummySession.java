package com.gam.testdouble.dummy.solution;

import com.gam.testdouble.dummy.Session;
import com.gam.testdouble.dummy.User;

import java.util.Date;

public class DummySession implements Session {
    @Override
    public Date getRequestDate() {
        return null;
    }

    @Override
    public User getLoggedInUser() {
        return null;
    }
}
