package com.sopra.TPVolSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.TPVolSpring.model.User;
import com.sopra.TPVolSpring.repositories.UserRoleRepositoy;
import com.sopra.TPVolSpring.repositories.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserRoleRepositoy userRoleRepository;
	
	
	public UsersRepository getUsersRepository() {
		return usersRepository;
	}


	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}


	public UserRoleRepositoy getUserRoleRepository() {
		return userRoleRepository;
	}


	public void setUserRoleRepository(UserRoleRepositoy userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt=usersRepository.findById(username);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get(), userRoleRepository.findCustomRoleByUsername(username));
		} else {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
	
	}

}
