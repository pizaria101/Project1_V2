package dev.schulte.services;

import dev.schulte.entities.AppUser;
import dev.schulte.entities.Role;

public interface AppUserService {

    public AppUser registerUser(AppUser appUser);

    public AppUser changeUserRole(int id, Role role);
}
