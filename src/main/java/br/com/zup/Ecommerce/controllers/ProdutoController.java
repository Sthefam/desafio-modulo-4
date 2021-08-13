package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import br.com.zup.Ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProdutos(@RequestBody @Valid ProdutoDTO produtoDto){
        produtoService.cadastrarProduto(produtoDto);
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> exibirProdutos(){
        return produtoService.getProdutos();
    }

}
