package softuni.linkedout_validationlab.model.service;

import softuni.linkedout_validationlab.model.entity.UserRoleEntity;

import java.util.List;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private List<UserRoleEntity> roles;

    public UserServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }
}
