package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO {

    private final Set<Cliente> SET;

    public ClienteSetDAO() {
        this.SET = new HashSet<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        return this.SET.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : this.SET) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            this.SET.remove(clienteEncontrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteExistente = consultar(cliente.getCpf());
        if (clienteExistente != null) {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setTel(cliente.getTel());
            clienteExistente.setNumero(cliente.getNumero());
            clienteExistente.setEnd(cliente.getEnd());
            clienteExistente.setCidade(cliente.getCidade());
            clienteExistente.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(long cpf) {
        for (Cliente cliente : this.SET) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return new HashSet<>(this.SET);
    }
}

