package cl.nsandoval.poointerfaces.repositorio;

import cl.nsandoval.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
