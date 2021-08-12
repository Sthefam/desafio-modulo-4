package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.ClienteDTO;
import br.com.zup.Ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void cadastrarCliente(@RequestBody ClienteDTO clienteDto){
        clienteService.cadastrarCliente(clienteDto);
    }

    @GetMapping("cliente/{cpf}")
    public ClienteDTO pesquisarCliente(@PathVariable String cpf){
        return clienteService.pesquisarCliente(cpf);
    }

}
