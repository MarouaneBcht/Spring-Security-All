package ma.emsi.patientsmvc.security.userDetails.services;

import jakarta.transaction.Transactional;
import ma.emsi.patientsmvc.security.userDetails.entities.AppRole;
import ma.emsi.patientsmvc.security.userDetails.entities.AppUser;
import ma.emsi.patientsmvc.security.userDetails.repositories.AppRoleRepository;
import ma.emsi.patientsmvc.security.userDetails.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user!=null) throw new RuntimeException("User already exist");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Wrong Password");
        user = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        AppUser savedUser = appUserRepository.save(user);
        return savedUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole!=null) throw new RuntimeException("Role already exists");
        appRole = AppRole.builder()
                .role(role)
                .build();
        AppRole savedRole = appRoleRepository.save(appRole);
        return savedRole;
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("User doesn't exist");
        AppRole appRole = appRoleRepository.findById(role).get();
        appUser.getRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("User doesn't exist");
        AppRole appRole = appRoleRepository.findById(role).get();
        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}