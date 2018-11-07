package com.gam.testdouble.stub;

@SuppressWarnings("unused")
public class LoginService {

    private Authorizer authorizer;

    public LoginService(Authorizer authorizer) {
        this.authorizer = authorizer;
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        UserId userId = authorizer.authorize(request.getUsername(), request.getPassword());
        if (!userId.isValid()) {
            response.setMessage(LoginResponse.LOGIN_FAILIER_MESSAGE);
            return response;
        }
        response.setMessage(LoginResponse.LOGIN_SUCCESS_MESSAGE);
        // ...
        return response;
    }
}
