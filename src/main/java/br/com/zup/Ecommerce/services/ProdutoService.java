package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import br.com.zup.Ecommerce.exceptions.CapturarErroException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void verificaDuplicidade(ProdutoDTO produtoDto){
        for(ProdutoDTO produto : produtos){
           if(produto.getNome().equals(produtoDto.getNome())){
               throw new CapturarErroException("Produto já cadastrado!");
           }
        }
    }

    public ProdutoDTO validarProduto(ProdutoDTO produtoDto){
        for(ProdutoDTO produto : produtos){
            if(produto.getNome().equals(produtoDto.getNome())){
                verificaEstoque(produtoDto);
                produtoDto.setPreco(produto.getPreco() * produtoDto.getQuantidade());
                return produtoDto;
            }
        }
        throw new CapturarErroException("Nenhum produto encontrado com o nome '"+produtoDto.getNome()+"'");
    }

    public <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        Set<T> set = new LinkedHashSet<>();

        set.addAll(list);

        list.clear();

        list.addAll(set);

        return list;
    }

    public void verificaEstoque(ProdutoDTO produtoDto){
        ArrayList<String> produtosForaDeEstoque = new ArrayList<>();
        for(ProdutoDTO produto : produtos){
            if(produto.getQuantidade() < produtoDto.getQuantidade()){
                produtosForaDeEstoque.add(produto.getNome());
                produtosForaDeEstoque = removeDuplicates(produtosForaDeEstoque);
            }
        }
        if(produtosForaDeEstoque.size() > 0){
            throw new CapturarErroException("Produto(s) fora de estoque: "+produtosForaDeEstoque);
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
