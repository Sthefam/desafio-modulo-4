package br.com.zup.Ecommerce.dtos;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CompraDTO {

    @NotNull(message = "{validation.objeto.cliente}")
    private ClienteDTO cliente;
    @NotNull(message = "{validation.lista.produtos}")
    private List<ProdutoDTO> produtos;

    public CompraDTO() {
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
