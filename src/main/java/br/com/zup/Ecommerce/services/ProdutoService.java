package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private List<ProdutoDTO> produtos;

    public void verificaDuplicidade(ProdutoDTO produtoDto){
        for(ProdutoDTO produto : produtos){
           if(produto.getNome().equals(produtoDto.getNome())){
               throw new RuntimeException("Produto já cadastrado!");
           }
        }
    }

    public void cadastrarProduto(ProdutoDTO produtoDto){
        verificaDuplicidade(produtoDto);
        produtos.add(produtoDto);
    }

}
