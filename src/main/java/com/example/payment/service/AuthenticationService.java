package com.example.payment.service;


import com.example.payment.config.jwtService;
import com.example.payment.model.*;
import com.example.payment.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationService {
    private final PersonRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final jwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public authenticationResponse register(registerRequest request){
        securityUser user = securityUser.builder()
                .name(request.getName())
                .userName(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(ServiceConsumer.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .name(user.getName())
                        .role(user.getRole())
                .build());
        return new authenticationResponse(jwtService.generateToken(user));
    }

    public authenticationResponse authenticate(authenticationRequest request) {
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        ));

        ServiceConsumer user1 = userRepo.findByUsername(request.getUsername()).orElseThrow();
        securityUser user = securityUser.builder()
                .name(user1.getName())
                .userName(user1.getUsername())
                .password(passwordEncoder.encode(user1.getPassword()))
                .role(Role.USER)
                .build();


        return new authenticationResponse(jwtService.generateToken(user));
    }
}
