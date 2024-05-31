package com.nexus.processnet.services;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService extends PessoaService<FuncionarioModel> {

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        super(funcionarioRepository);
    }

    @Transactional
    @Override
    public FuncionarioModel update(Long id, FuncionarioModel funcionario) {
        return pessoaRepository.findById(id).map(existingFuncionario -> {
            if (funcionario.getNome() != null) existingFuncionario.setNome(funcionario.getNome());
            if (funcionario.getEmail() != null) existingFuncionario.setEmail(funcionario.getEmail());
            if (funcionario.getTelefone() != null) existingFuncionario.setTelefone(funcionario.getTelefone());
            if (funcionario.getCargo() != null) existingFuncionario.setCargo(funcionario.getCargo());
            return pessoaRepository.save(existingFuncionario);
        }).orElseThrow(() -> new IllegalArgumentException("Funcionário não localizado com ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public FuncionarioModel findByCargo(String cargo) {
        return ((FuncionarioRepository) pessoaRepository).findByCargo(cargo)
                .orElseThrow(() -> new IllegalArgumentException("Nenhum funcionário encontrado com o cargo: " + cargo));
    }
}
