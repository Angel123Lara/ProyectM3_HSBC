package lara.pers.ProjectM2.controller;

import lara.pers.ProjectM2.Auth.AuthResponse;
import lara.pers.ProjectM2.Auth.AuthService;
import lara.pers.ProjectM2.Auth.LoginRequest;
import lara.pers.ProjectM2.Auth.RegisterRequest;
import lara.pers.ProjectM2.controller.handlers.DbException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public String start(){
        log.info("Acceso a pagina principal de Usuario");
        return "Bienvenido a Auth";
    }
        @PostMapping("/login")
        public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
        {
            try {
                return ResponseEntity.ok(authService.login(request));
            }catch (Exception ex){
                throw new DbException("DB Error",ex.getMessage());
            }
        }

        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws Exception
        {
            try {
                authService.register(request);
                return ResponseEntity.ok("Usuario registrado"+" "+ request.getUsername());
            }catch (Exception ex){
                throw new DbException("DB Error", ex.getMessage());
            }
        }
    }

