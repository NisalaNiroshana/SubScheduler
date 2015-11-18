package com.example.vaadintest;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class MyLoginForm extends com.ejt.vaadin.loginform.LoginForm {
	@Override
    protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
        GridLayout layout = new GridLayout(4,4);
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.addComponent(userNameField,1,1);
        layout.addComponent(passwordField,2,1);
        layout.addComponent(loginButton,2,2);
        layout.setComponentAlignment(loginButton, Alignment.BOTTOM_RIGHT);
        return layout;
    }

    // You can also override this method to handle the login directly, instead of using the event mechanism
    @Override
	protected void login(String userName, String password) {
        System.err.println(
            "Logged in with user name " + userName +
            " and password of length " + password.length()
        );
    }
}
