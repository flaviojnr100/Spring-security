package com.flavio.seguranca.service;

import com.flavio.seguranca.model.Role;
import com.flavio.seguranca.model.Usuario;
import com.flavio.seguranca.repository.UserRepository;
import com.flavio.seguranca.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Usuário não cadastro na base de dados");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getSenha(),authorities);
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return userRepository.save(usuario);
    }

    @Override
    public Usuario fetchUser(long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<Usuario> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public Usuario update(long id, Usuario usuario) {
        return null;
    }

    @Override
    public Usuario delete(long id) {
        return null;
    }

    @Override
    public Usuario addRole(String email, String roleName) {
        Usuario usuario = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        usuario.getRoles().add(role);
        return userRepository.save(usuario);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> fetchRoles() {
        return roleRepository.findAll();
    }
}
