package com.gam.testdouble.dummy;

import java.util.Date;

public interface Session {

    Date getRequestDate();

    User getLoggedInUser();
}
