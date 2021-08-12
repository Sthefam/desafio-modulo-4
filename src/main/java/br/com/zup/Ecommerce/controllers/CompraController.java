package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.CompraDTO;
import br.com.zup.Ecommerce.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
