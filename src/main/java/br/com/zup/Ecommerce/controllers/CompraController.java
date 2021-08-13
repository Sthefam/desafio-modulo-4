package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.CompraDTO;
import br.com.zup.Ecommerce.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/compras")
    public void efetuarCompra(@RequestBody CompraDTO compraDto){
        compraService.efetuarCompra(compraDto);
    }

    @GetMapping("/compras")
    public List<CompraDTO> exibirCompras(){
        return compraService.getCompras();
    }

    @GetMapping("/compras/{cpf}")
    public CompraDTO exibirComprasPorCpf(@PathVariable String cpf){
        return compraService.exibirComprasPorCpf(cpf);
    }

}
