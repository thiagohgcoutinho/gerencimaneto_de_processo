package com.nexus.processnet.controllers;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.models.LoginModel;
import com.nexus.processnet.services.FuncionarioService;
import com.nexus.processnet.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> getAllFuncionarios() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> getFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateFuncionario(@RequestBody LoginModel loginRequest) {
        try {
            String result = loginService.authenticateFuncionario(loginRequest.getCpf(), loginRequest.getSenha());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> createFuncionario(@RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.create(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
