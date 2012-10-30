package com.olivee.hrmanager.web.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.olivee.hrmanager.SystemProperties;

public class UserDetailService implements UserDetailsService {

	@Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
		String userName = (String)SystemProperties.get(SystemProperties.SUPPER_USER_NAME);
		String userPassword = (String)SystemProperties.get(SystemProperties.SUPPER_USER_PASSWORD);
		if(userName==null || userName.trim().equals("") || userPassword==null || userPassword.trim().equals("")){
			throw new UsernameNotFoundException("not config administrators!");
		}
		if(!userName.equals(username)){
			throw new UsernameNotFoundException(username + "user not found!");
		}
		
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        auths.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        
        User user = new User(username,
        		userPassword, true, true, true, true, auths);
        
        return user;
    }
    
}
