/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.util.Scanner;

/**
 *
 * @author Rosa
 */
public class MisVehiculos {

    public static void main(String[] args) {

//        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
//        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive",
//                "www.easydrive.com");
//// registro de los clientes de la empresa
//        easydrive.registrarCliente(new Cliente("X5618927C",
//                "Juan", "González López"));
//
//        easydrive.registrarCliente(new Cliente("Z7568991Y",
//                "Luis", "Fernández Gómez"));
//
//// registro de los vehículos de la empresa
//        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda",
//                "Fabia", "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang",
//                "Rojo", 150.0, true));
//
//        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza",
//                "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato",
//                "Azul", 80.0, true));
//// imprime la relación de clientes de easydrive
//        easydrive.imprimirClientes();
//// imprime el catálogo de vehículos de easydrive
//        easydrive.imprimirVehiculos();
//        
//        
//        Vehiculo uno= new Vehiculo();
//        
//        System.out.println(uno);
//        Cliente clUno= new Cliente();
//        
//        System.out.println(clUno);
//        
//        //Creamos empresa
//       
        Scanner teclado= new Scanner(System.in);
        EmpresaAlquilerVehiculos prueba= new EmpresaAlquilerVehiculos("9889u7", "Derp", "www.hellomadafaka.com");
        
        prueba.rellenarVehiculos();
        prueba.rellenarClientes();
        prueba.imprimirClientes();
        System.out.println("------------------");
        prueba.imprimirVehiculos();
        prueba.burbujaCliente();
        prueba.burbujaVehiculos();
        prueba.imprimirClientes();
        System.out.println("------------------");
        prueba.imprimirVehiculos();
        
        System.out.println("Introduzca Nif a buscar:");
        String aux=teclado.nextLine();
        
        prueba.busquedaNif(aux);
        
        if(prueba.busquedaNif(aux)==-1){
            System.out.println("No se ha encontrado");
        }else{
            System.out.println("Lo hemos encontrado en la posición "+prueba.busquedaNif(aux));
        }
        
    }
}
