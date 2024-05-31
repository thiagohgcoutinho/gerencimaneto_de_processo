package com.nexus.processnet.services;

import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.repositories.UsuarioRepository;
import com.nexus.processnet.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService extends PessoaService<UsuarioModel> {

    @Autowired
    private ProcessoRepository processoRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    @Transactional
    public void delete(Long idPessoa) {
        UsuarioModel usuario = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + idPessoa));

        if (processoRepository.existsByResponsavel_IdPessoa(idPessoa)) {
            throw new IllegalStateException("Não é possível excluir usuário com processos associados.");
        }

        pessoaRepository.deleteById(idPessoa);
    }
}
