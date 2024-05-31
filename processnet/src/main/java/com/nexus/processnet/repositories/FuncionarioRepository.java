package com.nexus.processnet.repositories;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    Optional<FuncionarioModel> findByCargo(String cargo);
    Optional<FuncionarioModel> findByCpf(String cpf);
}
