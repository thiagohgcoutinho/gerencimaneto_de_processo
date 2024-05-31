package com.nexus.processnet.models;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_USUARIO")
@PrimaryKeyJoinColumn(name = "idPessoa")
@Data
public class UsuarioModel extends PessoaModel{


    public UsuarioModel() {
        super();
    }
}