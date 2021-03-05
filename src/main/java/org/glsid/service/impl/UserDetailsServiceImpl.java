package org.glsid.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.glsid.entitie.CompteEmploye;
import org.glsid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
	@Service
public class UserDetailsServiceImpl implements UserDetailsService{
		@Autowired
		private	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CompteEmploye user=accountService.findCompteEmployeByUsername(username);	
		if(user==null) throw new UsernameNotFoundException(username);
		
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		user.getRoles().forEach(r->{
		authorities.add(new SimpleGrantedAuthority(r.getLibelle()));
		});
		return new User(user.getUsername(),user.getPassword(),authorities);
	}

}
