package dev.schulte.controllers;

import dev.schulte.entities.AppUser;
import dev.schulte.entities.Role;
import dev.schulte.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/users")
    public AppUser createAppUser(@RequestBody AppUser appUser){
        return this.appUserService.registerUser(appUser);
    }

    @PutMapping("/users/{id}/{role}")
    public AppUser updateUserRole(@PathVariable("id") String id, @PathVariable("role") String role){
        int appUserId = Integer.parseInt(id);
        AppUser appUser = new AppUser();
        switch(role.toLowerCase()){

            case "registered":
                appUser = this.appUserService.changeUserRole(appUserId, Role.REGISTERED);
                break;

            case "council":
                appUser = this.appUserService.changeUserRole(appUserId, Role.COUNCIL_MEMBER);
                break;
        }

        return appUser;
    }
}
