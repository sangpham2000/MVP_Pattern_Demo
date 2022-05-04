package com.example.mvppatterndemo.signin;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvppatterndemo.R;
import com.example.mvppatterndemo.main.MainActivity;
import com.example.mvppatterndemo.signup.SignUpActivity;

public class SignInActivity extends AppCompatActivity implements SignInContract.View,
        View.OnClickListener {

    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mButtonSignIn;
    private TextView mButtonSignUp;
    private SignInPresenter mSignInPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initView();
        registerListener();
        initPresenter();
    }

    private void initView() {
        mTextUsername = findViewById(R.id.text_username);
        mTextPassword = findViewById(R.id.text_password);
        mButtonSignIn = findViewById(R.id.button_sign_in);
        mButtonSignUp = findViewById(R.id.button_sign_up);
    }

    private void registerListener() {
        mButtonSignIn.setOnClickListener(this);
        mButtonSignUp.setOnClickListener(this);
    }

    private void initPresenter() {
        mSignInPresenter = new SignInPresenter();
        mSignInPresenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_in:
                login();
                break;
            case R.id.button_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            default:
                break;
        }
    }

    private void login() {
        User user = new User();
        user.setUsername(mTextUsername.getText().toString());
        user.setPassword(mTextPassword.getText().toString());
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            Toast.makeText(this, "Username or Password is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        mSignInPresenter.handleSignIn(user);
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Sign In Success!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
