package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.CompraDTO;
import br.com.zup.Ecommerce.dtos.ProdutoDTO;
import br.com.zup.Ecommerce.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/compra")
    @ResponseStatus(HttpStatus.CREATED)
    public void efetuarCompra(@RequestBody @Valid CompraDTO compraDto){
        compraService.efetuarCompra(compraDto);
    }

    @GetMapping("/compras")
    public List<CompraDTO> exibirCompras(){
        return compraService.getCompras();
    }

    @GetMapping("/compras/{cpf}")
    public List<List<ProdutoDTO>> exibirComprasPorCpf(@PathVariable String cpf){
        return compraService.exibirComprasPorCpf(cpf);
    }

}
