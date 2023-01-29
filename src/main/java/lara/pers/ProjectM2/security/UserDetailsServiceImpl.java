package lara.pers.ProjectM2.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.UsuarioDTO;
import lara.pers.ProjectM2.service.ClienteService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ClienteService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDTO usuario = service.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El correo no se encontró"));
        return new UserDetailsImpl(usuario);
    }
}
