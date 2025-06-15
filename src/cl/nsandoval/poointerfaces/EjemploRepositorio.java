package cl.nsandoval.poointerfaces;

import cl.nsandoval.poointerfaces.modelo.Cliente;
import cl.nsandoval.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Nelson","sandoval"));
        repo.crear(new Cliente("Nelson","sandoval"));
        repo.crear(new Cliente("Nelson","sandoval"));
        repo.crear(new Cliente("Nelson","sandoval"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("==== paginable list ====");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1,4);
        paginable.forEach(System.out::println);

        System.out.println("==== ordenar ====");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo).listar("nombre", Direccion.DESC);

        for (Cliente c : clientesOrdenAsc) {
            System.out.println(c);
        }

        System.out.println("==== editar ====");
        Cliente beaActualizar = new Cliente("Javier","sandoval");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("==== remover ====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);



    }
}
