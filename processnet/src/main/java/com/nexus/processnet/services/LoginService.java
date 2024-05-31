package com.nexus.processnet.services;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.repositories.FuncionarioRepository;
import com.nexus.processnet.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public String authenticateUsuario(String cpf, String senha) {
        UsuarioModel usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("CPF não encontrado"));

        if (!usuario.getSenha().equals(senha)) {
            return "Senha incorreta";
        }

        return "Autenticação bem-sucedida";
    }

    public String authenticateFuncionario(String cpf, String senha) {
        FuncionarioModel funcionario = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("CPF não encontrado"));

        if (!funcionario.getSenha().equals(senha)) {
            return "Senha incorreta";
        }

        return "Autenticação bem-sucedida";
    }
}
