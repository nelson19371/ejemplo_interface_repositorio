package cl.nsandoval.generics;

import cl.nsandoval.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList();
        clientes.add(new Cliente("Nelson","Sandoval"));
        Cliente cliente = (Cliente) clientes.iterator().next();
        Cliente[] clientesArreglo = {new Cliente("Nelson","Sandoval"), new Cliente("Javier","Sandoval")};
        Integer[] enterosArreglo = {1,2,3};
        List<Cliente> clientesLista = Arrays.asList(clientesArreglo);
        List<Integer> enterosLista = Arrays.asList(enterosArreglo);
        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andrés","Pepe","Luci","Bea","John"}, enterosArreglo);

    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T,G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento: x){
            System.out.println( elemento );
        }
        return Arrays.asList(c);
    }

}
