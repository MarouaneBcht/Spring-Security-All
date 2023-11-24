package ma.emsi.patientsmvc.security.userDetails.repositories;

import ma.emsi.patientsmvc.security.userDetails.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
