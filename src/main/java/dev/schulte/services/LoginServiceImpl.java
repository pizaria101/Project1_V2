package dev.schulte.services;

import dev.schulte.dtos.LoginCredentials;
import dev.schulte.entities.AppUser;
import dev.schulte.exceptions.UsernamePasswordMismatchException;
import dev.schulte.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    JwtService jwtService;

    @Override
    public String authenticateUser(LoginCredentials loginCredentials) {
        AppUser appUser = appUserRepo.findByUsername(loginCredentials.getUsername());

        if(!appUser.getPassword().equals(loginCredentials.getPassword()))
        {
            throw new UsernamePasswordMismatchException("Username/password does not match");
        }

        return jwtService.createJwtWithUsernameAndRole(appUser.getUsername(), appUser.getRole().toString());
    }
}
