package com.example.proto.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private String role;

    public String getRole() {
        return role;
    }

    public Set<User> getUsersWithRole() {
        return usersWithRole;
    }

    public void setUsersWithRole(Set<User> usersWithRole) {
        this.usersWithRole = usersWithRole;
    }

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> usersWithRole;

    private Role() {
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
