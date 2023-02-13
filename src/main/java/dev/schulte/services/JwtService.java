package dev.schulte.services;

public interface JwtService {

    String createJwtWithUsernameAndRole(String username, String role);

    boolean validateJwt(String jwt);
}

