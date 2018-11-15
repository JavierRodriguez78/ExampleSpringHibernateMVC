package com.geekshubsacademy.demohibernatespringmvc.app.config;

import com.geekshubsacademy.demohibernatespringmvc.domain.dao.IUsuarioDao;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class MyAppUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao userInfoDAO;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuarios activeUserInfo = userInfoDAO.getUsuarioActivo(s);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        UserDetails userDetails =
                new User(activeUserInfo.getUsername(),
                        activeUserInfo.getPassword(),
                        Arrays.asList(authority));
        return userDetails;
    }
}
