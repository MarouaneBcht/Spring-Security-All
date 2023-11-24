package ma.emsi.patientsmvc.security.userDetails.services;

import ma.emsi.patientsmvc.security.userDetails.entities.AppRole;
import ma.emsi.patientsmvc.security.userDetails.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String email, String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
