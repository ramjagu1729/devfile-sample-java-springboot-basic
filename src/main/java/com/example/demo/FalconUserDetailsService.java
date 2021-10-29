package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class FalconUserDetailsService implements UserDetailsService{
	@Autowired
    private FalconuserRepository falconuserRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Falconuser falconuser = falconuserRepository.findByEmail(username);
        if (falconuser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new FalconuserDetails(falconuser);
    }

}
