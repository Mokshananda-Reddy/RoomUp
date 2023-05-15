package com.roomup.backend.Jwtutils;

import com.roomup.backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    LoginRepository userRepository;

    @Override
    @Transactional

    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority("manager"));
        authList.add(new SimpleGrantedAuthority("student"));
        authList.add(new SimpleGrantedAuthority("admin"));

        User userByName = new User(mobile, "Mokshananda", authList);
        return new org.springframework.security.core.userdetails.User(userByName.getUsername(), userByName.getPassword(), userByName.getAuthorities());
    }
    public UserDetails loadLoginByUsername(String username, String password) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority("manager"));
        authList.add(new SimpleGrantedAuthority("student"));
        authList.add(new SimpleGrantedAuthority("admin"));

        User userByName = new User(username, password, authList);
        return new org.springframework.security.core.userdetails.User(userByName.getUsername(), userByName.getPassword(), userByName.getAuthorities());
    }

}