package com.example.mvppatterndemo.signin;

public interface SignInContract {
    interface View {
        void signInSuccess();

        void signInFailure(String error);
    }

    interface Presenter {
        void handleSignIn(User user);
    }
}