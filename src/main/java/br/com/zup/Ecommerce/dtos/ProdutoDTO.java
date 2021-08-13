package br.com.zup.Ecommerce.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoDTO {

    @NotBlank(message = "{validation.nome.produto}")
    @Size(min = 3, message = "{validation.nome.produto.tamanho}")
    private String nome;
    @Min(value = 0, message = "{validation.quantidade}")
    private int quantidade;
    @NotNull(message = "{validation.preco}")
    private double preco;

    public ProdutoDTO() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
