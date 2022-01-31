package com.flavio.seguranca.repository;

import com.flavio.seguranca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
}
