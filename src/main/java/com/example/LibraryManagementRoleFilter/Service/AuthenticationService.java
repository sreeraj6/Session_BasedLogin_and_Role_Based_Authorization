package com.example.LibraryManagementRoleFilter.Service;

import com.example.LibraryManagementRoleFilter.Dto.RegisterRequest;
import com.example.LibraryManagementRoleFilter.Repository.UserRepository;
import com.example.LibraryManagementRoleFilter.Model.User;
import com.example.LibraryManagementRoleFilter.Model.Role;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(User request) {
        if(userRepository.findByEmail(request.getEmail()) != null) {
            return null;
        }
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STAFF)
                .build();

        userRepository.save(user);

        return user;
    }

    public User authenticate(RegisterRequest request, HttpSession session) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail());
        if(user != null) {
            session.setAttribute("username", user.getUsername());
        }
        return user;
    }
}
