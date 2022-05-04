package com.example.mvppatterndemo.signin;

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;

    public void setView(SignInContract.View view) {
        mView = view;
    }

    public void handleSignIn(User user) {
        if (user.getUsername().equals("sangpham1150") && user.getPassword().equals("1234")) {
            mView.signInSuccess();
            return;
        }

        mView.signInFailure("Username or Password not true!");
    }
}