package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.dtos.ClienteDTO;
import br.com.zup.Ecommerce.dtos.CompraDTO;
import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CompraService {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    private List<CompraDTO> compras = new ArrayList<>();

    public void efetuarCompra(CompraDTO compraDTO){
        ClienteDTO cliente = clienteService.pesquisarCliente(compraDTO.getCliente().getCpf());
        compraDTO.setCliente(cliente);
        List<ProdutoDTO> produtosVerificados = compraDTO.getProdutos().stream().map(produto -> produtoService.validarProduto(produto)).collect(Collectors.toList());
        compraDTO.setProdutos(produtosVerificados);
        compras.add(compraDTO);
    }

    public List<CompraDTO> getCompras(){
        return this.compras;
    }

}
