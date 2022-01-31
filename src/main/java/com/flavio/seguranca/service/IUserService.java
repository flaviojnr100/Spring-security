package com.flavio.seguranca.service;

import com.flavio.seguranca.model.Role;
import com.flavio.seguranca.model.Usuario;

import java.util.List;

public interface IUserService{

    public Usuario save(Usuario usuario);
    public Usuario fetchUser(long id);
    public List<Usuario> fetchUsers();
    public Usuario update(long id, Usuario usuario);
    public Usuario delete(long id);
    public Usuario addRole(String email, String roleName);

    public Role saveRole(Role role);
    public List<Role> fetchRoles();

}
