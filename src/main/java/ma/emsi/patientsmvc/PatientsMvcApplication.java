package ma.emsi.patientsmvc;


import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import ma.emsi.patientsmvc.security.userDetails.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Marouane", new Date(), true,196));
            patientRepository.save(new Patient(null, "Bouchtaoui", new Date(), false,374));
            patientRepository.save(new Patient(null, "Oussama", new Date(), true,265));
            patientRepository.save(new Patient(null, "Mohamed", new Date(), true,152));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }

        //@Bean
        CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails user111 = jdbcUserDetailsManager.loadUserByUsername("user111");
            if (user111==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername("user111")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER")
                            .build()
                    );
            UserDetails user222 = jdbcUserDetailsManager.loadUserByUsername("user222");
            if (user222==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername("user222")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER")
                            .build()
            );
            UserDetails admin111 = jdbcUserDetailsManager.loadUserByUsername("admin111");
            if (admin111==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername(" ")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER","ADMIN")
                            .build()
            );
        };
    }

    @Bean
    CommandLineRunner lunch(AccountService accountService) {
        return args -> {
            accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("user11","1234","user11@users.com","1234");
            accountService.addNewUser("user22","1234","user22@users.com","1234");
            accountService.addNewUser("admin11","1234","admin11@admins.com","1234");
            accountService.addRoleToUser("user11","USER");
            accountService.addRoleToUser("user22","USER");
            accountService.addRoleToUser("admin11","USER");
            accountService.addRoleToUser("admin11","ADMIN");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}