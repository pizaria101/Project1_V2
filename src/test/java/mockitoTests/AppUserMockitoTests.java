package mockitoTests;

import dev.schulte.entities.AppUser;
import dev.schulte.entities.Role;
import dev.schulte.repos.AppUserRepo;
import dev.schulte.services.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class AppUserMockitoTests {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AppUserService appUserService;

    @Test
    public void create_user_username_mock(){
        AppUserRepo appUserTestRepo = Mockito.mock(AppUserRepo.class);
        AppUser appUser = new AppUser(1, "", "licish", Role.UNREGISTERED);

        Mockito.when(appUserTestRepo.save(appUser)).thenReturn(appUser);
        Assertions.assertThrows(RuntimeException.class, () ->{
            this.appUserService.registerUser(appUser);
        });
    }

    @Test
    public void update_user_role_mock(){
        AppUserRepo appUserTestRepo = Mockito.mock(AppUserRepo.class);
        Assertions.assertThrows(RuntimeException.class, () ->{
           this.appUserService.changeUserRole(1, Role.REGISTERED);
        });
    }
}
