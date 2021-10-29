package com.example.demo;


import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class FalconuserDetails implements UserDetails {
 
    private Falconuser falconuser;
     
    public FalconuserDetails(Falconuser falconuser) {
        this.falconuser = falconuser;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return falconuser.getPassword();
    }
 
    @Override
    public String getUsername() {
        return falconuser.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return falconuser.getFirstname() + " " + falconuser.getLastname();
    }
 
}