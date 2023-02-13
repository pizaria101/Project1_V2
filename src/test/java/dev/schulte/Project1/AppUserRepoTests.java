package dev.schulte.Project1;

import dev.schulte.entities.AppUser;
import dev.schulte.entities.Role;
import dev.schulte.repos.AppUserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AppUserRepoTests {

    @Autowired
    AppUserRepo appUserRepo;

    @Test
    public void find_user_by_username_test(){
        AppUser appUser1 = new AppUser(0, "eatemup1", "badpass", Role.REGISTERED);
        this.appUserRepo.save(appUser1);

        AppUser appUser2 = new AppUser(0, "eatemup2", "badpass1", Role.REGISTERED);
        this.appUserRepo.save(appUser2);

        AppUser appUser = this.appUserRepo.findByUsername("eatemup1");
        Assertions.assertEquals("eatemup1", appUser.getUsername());
    }
}
