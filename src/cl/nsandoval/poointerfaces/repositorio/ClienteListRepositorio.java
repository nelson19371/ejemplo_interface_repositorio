package cl.nsandoval.poointerfaces.repositorio;

import cl.nsandoval.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<Cliente>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(int id) {
        Cliente resultado = null;
        for (Cliente cli : dataSource) {
            if (cli.getId() == id) {
                resultado = cli;
            }

        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);

    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminar(int id) {
        this.dataSource.remove(this.porId(id));

    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {

        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if(dir == Direccion.ASC) {
                    switch(campo) {
                        case "id" ->
                            resultado = a.getId() - b.getId();
                        case "nombre" -> resultado = a.getNombre().compareToIgnoreCase(b.getNombre());
                        case "apellido" -> resultado = a.getApellido().compareToIgnoreCase(b.getApellido());
                    }

                }else if(dir == Direccion.DESC) {
                    switch(campo) {
                        case "id" ->
                                resultado = a.getId() - b.getId();
                        case "nombre" -> resultado = b.getNombre().compareToIgnoreCase(a.getNombre());
                        case "apellido" -> resultado = b.getApellido().compareToIgnoreCase(a.getApellido());
                    }
                }
                return resultado;
            });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }


    @Override
    public int total() {
        return this.dataSource.size();
    }
}
