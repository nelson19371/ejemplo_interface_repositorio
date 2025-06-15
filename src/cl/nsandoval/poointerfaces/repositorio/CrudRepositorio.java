package cl.nsandoval.poointerfaces.repositorio;

import cl.nsandoval.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> listar();
    Cliente porId(int id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(int id);


}
