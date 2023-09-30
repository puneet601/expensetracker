package com.project.ExpenseTracker.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ExpenseTracker.dto.UserDto;
import com.project.ExpenseTracker.entity.Role;
import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.models.LoginResponseDTO;
import com.project.ExpenseTracker.repository.RoleRepository;
import com.project.ExpenseTracker.repository.UserRepository;
import com.project.ExpenseTracker.service.AuthenticationService;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{	
	

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    
    
    @Override
	public User registerUser(User user) {	
		encodePassword(user);
		Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        user.setAuthorities(authorities);
		return userRepository.save(user);		
	}
	
	private void encodePassword(User user) {
		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
	}

	@Override
    public LoginResponseDTO login(UserDto userDto){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findUserByEmail(userDto.getEmail()), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }
    
    

}