package br.com.zup.Ecommerce.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDTO {

    @NotBlank(message = "{validation.nome.cliente}")
    @Size(min = 3, message = "{validation.nome.cliente.tamanho}")
    private String nome;
    @NotBlank(message = "{validation.cpf}")
    @Size(min = 11, max = 14, message = "{validation.cpf.tamanho}")
    private String cpf;
    @NotBlank(message = "{validation.email.vazio}")
    @Email(message = "{validation.email.valido}")
    private String email;

    public ClienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
