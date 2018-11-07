package com.gam.testdouble.spy;

public class ObjectMother {

    public static User createValidUser() {
        User user = new User();
        user.setId(TestHelper.VALID_USER_ID);
        user.setUsername(TestHelper.VALID_USERNAME);
        user.setPassword(CryptionUtil.encrypt(TestHelper.VALID_PASSWORD));
        return user;
    }

    public static Credential createValidCredential() {
        return new Credential(TestHelper.VALID_USERNAME, TestHelper.VALID_PASSWORD);
    }
}
