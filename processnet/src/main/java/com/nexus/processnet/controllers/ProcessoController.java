package com.nexus.processnet.controllers;

import com.nexus.processnet.models.*;
import com.nexus.processnet.services.ProcessoService;
import com.nexus.processnet.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ProcessoModel>> getAllProcessos() {
        return ResponseEntity.ok(processoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessoModel> getProcessoById(@PathVariable Long id) {
        return ResponseEntity.ok(processoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProcessoModel> createProcesso(@RequestBody ProcessoModel processo) {
        ProcessoModel novoProcesso = processoService.create(processo);
        return ResponseEntity.ok(novoProcesso);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ProcessoModel> updateProcessoStatus(@PathVariable Long id, @RequestParam Status status) {
        processoService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/parecer")
    public ResponseEntity<ProcessoModel> updateProcessoParecer(@PathVariable Long id, @RequestParam Parecer parecer) {
        processoService.updateParecer(id, parecer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/selecionar")
    public ResponseEntity<?> selectProcesso(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        try {
            processoService.selectProcesso(id, funcionario);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/responsavel/{idPessoa}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByResponsavel(@PathVariable Long idPessoa) {
        List<ProcessoModel> processos = processoService.findByResponsavel(idPessoa);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByTipo(@PathVariable TipoProcesso tipo) {
        List<ProcessoModel> processos = processoService.findByTipoProcesso(tipo);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByStatus(@PathVariable Status status) {
        List<ProcessoModel> processos = processoService.findByStatus(status);
        return ResponseEntity.ok(processos);
    }
}
