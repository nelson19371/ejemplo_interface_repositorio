package cl.nsandoval.poointerfaces.repositorio;

import cl.nsandoval.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
