package com.example.LibraryManagementRoleFilter.Controller;

import com.example.LibraryManagementRoleFilter.Dto.RegisterRequest;
import com.example.LibraryManagementRoleFilter.Service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import com.example.LibraryManagementRoleFilter.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableMethodSecurity
public class DemoController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/auth/check")
    public String check(){
        return "hsdiflsdf";
    }
    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return authenticationService.register(user);
    }
    @PostMapping("/auth/login")
    public User login(@RequestBody RegisterRequest request, HttpSession session) {
        return authenticationService.authenticate(request, session);
    }
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/demo")
    public String demo(){
        return "sample";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String deom1(){
        return "abcded";
    }
}
