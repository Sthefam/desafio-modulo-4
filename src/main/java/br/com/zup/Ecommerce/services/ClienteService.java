package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.dtos.ClienteDTO;
import br.com.zup.Ecommerce.exceptions.CapturarErroException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<ClienteDTO> clientes = new ArrayList<>();

    public void verificaDuplicidade(ClienteDTO clienteDto){
        for(ClienteDTO cliente : clientes){
            if(cliente.getCpf().equals(clienteDto.getCpf()) || cliente.getEmail().equals(clienteDto.getEmail())){
                throw new CapturarErroException("Cliente já cadastrado!");
            }
        }
    }

    public void cadastrarCliente(ClienteDTO clienteDto){
        verificaDuplicidade(clienteDto);
        clientes.add(clienteDto);
    }

    public ClienteDTO pesquisarCliente(String cpf){
        for(ClienteDTO cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        throw new CapturarErroException("Cliente não encontrado!");
    }

}
