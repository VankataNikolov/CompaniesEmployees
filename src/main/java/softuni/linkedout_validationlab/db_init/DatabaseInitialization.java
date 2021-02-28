package softuni.linkedout_validationlab.db_init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.linkedout_validationlab.model.entity.UserEntity;
import softuni.linkedout_validationlab.model.entity.UserRoleEntity;
import softuni.linkedout_validationlab.model.entity.enums.UserRole;
import softuni.linkedout_validationlab.repository.UserRepository;
import softuni.linkedout_validationlab.repository.UserRoleRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitialization implements CommandLineRunner {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseInitialization(UserRoleRepository userRoleRepository,
                                  UserRepository userRepository,
                                  PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            initRoles();
            initUsers();
        } catch (Exception e){
            throw new Exception();
        }

    }

    private void initRoles(){
        if(userRoleRepository.count() == 0){
            Arrays.stream(UserRole.values())
                    .forEach(role -> {
                        UserRoleEntity userRoleEntity = new UserRoleEntity(role);
                        userRoleRepository.save(userRoleEntity);
                    });
        }

    }

    private void initUsers(){
        if(userRepository.count() == 0){

            UserEntity admin = new UserEntity("admin", passwordEncoder.encode("12345"), userRoleRepository.findAll());
            UserEntity user = new UserEntity("user", passwordEncoder.encode("12345"), List.of(userRoleRepository.findByRole(UserRole.ROLE_USER)));

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}
