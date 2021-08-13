package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.dtos.ClienteDTO;
import br.com.zup.Ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDto){
        clienteService.cadastrarCliente(clienteDto);
    }

    @GetMapping("cliente/{cpf}")
    public ClienteDTO pesquisarCliente(@PathVariable String cpf){
        return clienteService.pesquisarCliente(cpf);
    }

}
