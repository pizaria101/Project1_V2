package dev.schulte.services;

import dev.schulte.entities.AppUser;
import dev.schulte.entities.Role;
import dev.schulte.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public AppUser registerUser(AppUser appUser) {

        if(appUser.getUsername().length() < 3){
            throw new RuntimeException("Username must be more than 3 characters");
        }

        if(appUser.getPassword().length() < 5){
            throw new RuntimeException("Password must be more than 5 characters");
        }

        return this.appUserRepo.save(appUser);
    }

    @Override
    public AppUser changeUserRole(int id, Role role) {

        Optional<AppUser> possibleAppUser = this.appUserRepo.findById(id);

        if(possibleAppUser.isPresent()){
            AppUser appUser = possibleAppUser.get();

            appUser.setRole(role);

            return this.appUserRepo.save(appUser);
        }else{
            throw new RuntimeException("User not found");
        }
    }


}
