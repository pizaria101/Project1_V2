package dev.schulte.services;

import dev.schulte.dtos.LoginCredentials;

public interface LoginService {

    String authenticateUser(LoginCredentials loginCredentials);
}
