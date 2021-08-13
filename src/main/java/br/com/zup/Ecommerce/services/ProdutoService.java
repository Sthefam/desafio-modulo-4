package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void verificaDuplicidade(ProdutoDTO produtoDto){
        for(ProdutoDTO produto : produtos){
           if(produto.getNome().equals(produtoDto.getNome())){
               throw new RuntimeException("Produto já cadastrado!");
           }
        }
    }

    public ProdutoDTO validarProduto(ProdutoDTO produtoDto){
        for(ProdutoDTO produto : produtos){
            if(produto.getNome().equals(produtoDto.getNome())){
                verificaEstoque(produtoDto);
                return produtoDto;
            }
        }
        throw new RuntimeException("Nenhum produto encontrado com o nome '"+produtoDto.getNome()+"'");
    }

    public void verificaEstoque(ProdutoDTO produtoDto){
        StringBuilder mensagem = new StringBuilder();
        for(ProdutoDTO produto : produtos){
            if(produto.getQuantidade() < produtoDto.getQuantidade()){
                mensagem.append("'").append(produtoDto.getNome()).append("'");
                throw new RuntimeException("Produto(s) fora de estoque: "+mensagem);
            }
        }
    }

    public void cadastrarProduto(ProdutoDTO produtoDto){
        verificaDuplicidade(produtoDto);
        produtos.add(produtoDto);
    }

    public List<ProdutoDTO> getProdutos(){
        return this.produtos;
    }

}
