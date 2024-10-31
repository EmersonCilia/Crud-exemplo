package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {

    private final Map<Long, Cliente> MAP;

    public ClienteMapDAO() {
        this.MAP = new HashMap<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (this.MAP.containsKey(cliente.getCpf())) {
            return false;
        }
        this.MAP.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.MAP.get(cpf);
        if (clienteCadastrado != null) {
            this.MAP.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.MAP.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());

        }
    }

    @Override
    public Cliente consultar(long cpf) {
        return this.MAP.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.MAP.values();
    }
}
