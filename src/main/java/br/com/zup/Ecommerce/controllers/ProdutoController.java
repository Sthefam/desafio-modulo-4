package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import br.com.zup.Ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public void cadastrarProdutos(@RequestBody ProdutoDTO produtoDto){
        produtoService.cadastrarProduto(produtoDto);
    }
}
