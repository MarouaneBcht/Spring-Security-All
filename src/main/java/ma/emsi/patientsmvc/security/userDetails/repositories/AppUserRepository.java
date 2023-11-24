package ma.emsi.patientsmvc.security.userDetails.repositories;

import ma.emsi.patientsmvc.security.userDetails.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}