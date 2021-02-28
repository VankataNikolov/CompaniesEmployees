package softuni.linkedout_validationlab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.linkedout_validationlab.model.entity.UserEntity;
import softuni.linkedout_validationlab.model.entity.enums.UserRole;
import softuni.linkedout_validationlab.model.service.UserServiceModel;
import softuni.linkedout_validationlab.repository.UserRepository;
import softuni.linkedout_validationlab.repository.UserRoleRepository;
import softuni.linkedout_validationlab.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

}
