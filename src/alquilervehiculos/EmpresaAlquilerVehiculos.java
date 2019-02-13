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
public class EmpresaAlquilerVehiculos {

    // Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;
    /* Atributos para controlar el total de clientes que tiene la
empresa y array de almacenamiento para los objetos Cliente */
    private int totalClientes;
    private Cliente[] clientes;
    /* Atributos para controlar el total de vehiculos disponibles en
alquiler que tiene la empresa y array de almacenamiento para los objetos
Vehiculo */
    private int totalVehiculos;
    private Vehiculo[] vehiculos;
    /* Atributos para controlar el histórico de alquileres: total de
alquileres realizados y array de almacenamiento para los objetos
VehiculoAlquilado */
    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;
// se omiten los métodos ‘get’ y ‘set’ de la clase
/* Constructor parametrizado donde se establece que el total de clientes
será 50, igual que el total de vehiculos disponibles. El histórico de
vehiculos puede contener hasta 100 elementos */
    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
        this.totalClientes = 0;
        this.clientes = new Cliente[50]; // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new Vehiculo[50]; // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new VehiculoAlquilado[100]; // apuntan a null
    }

    //método registrarCliente
    public void registrarCliente(Cliente nuevo) {
        this.clientes[this.totalClientes] = nuevo;
        this.totalClientes++;
    }

    //método registrar vehículo
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos[this.totalVehiculos] = nuevo;
        this.totalVehiculos++;
    }

    //Método imprimir clientes
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < this.clientes.length; i++) {
            System.out.println(clientes[i].getNif() + "\t" + clientes[i].getNombre());
        }
    }
    
    //Método que rellene vehiculos aleatorios
    public EmpresaAlquilerVehiculos rellenarVehiculos(EmpresaAlquilerVehiculos aux){
        
        for (int i = 0; i <aux.vehiculos.length; i++) {
            aux.vehiculos[i]=new Vehiculo();
         //   System.out.println(aux.vehiculos[i]);
        }
        
        return aux;
    }
    
    //Método que rellene clientes aleatorios
    public EmpresaAlquilerVehiculos rellenarClientes(EmpresaAlquilerVehiculos aux){
        
        for (int i = 0; i <this.clientes.length; i++) {
            aux.clientes[i]=new Cliente();
        }
        return aux;
    }
    public void rellenarVehiculos(){
        
        for (int i = 0; i <this.vehiculos.length; i++) {
            this.vehiculos[i]=new Vehiculo();
         //   System.out.println(aux.vehiculos[i]);
        }
        
    }
    
    //Método que rellene clientes aleatorios
    public void rellenarClientes(){
        
        for (int i = 0; i <this.clientes.length; i++) {
            this.clientes[i]=new Cliente();
        }

    }
    //método imprimir vehículos
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int i = 0; i < this.vehiculos.length; i++) {
            System.out.println(vehiculos[i].toString());
        }
    }

    //Método getCliente
    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes[i].getNif().equals(nif)) {
                return this.clientes[i];
            }

        }
        return null;
    }

    //Método getVehiculos
    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.getTotalVehiculos(); i++) {
            if (this.vehiculos[i].getMatricula().equals(matricula)) {
                return this.vehiculos[i];
            }
        }
        return null;
    }

    //método alquilarVehiculos
    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
// busca el cliente con el NIF dado en el array
// clientes y el vehículo con la matrícula dada en el
// array vehiculos, si el vehículo está disponible se
// alquila con la fecha actual, que se obtiene
// ejecutando los métodos diaHoy(), mesHoy() y
// añoHoy(), cuya declaración no se incluye
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres] = new VehiculoAlquilado(cliente, vehiculo, 15, 3, 2018, dias);

            this.totalAlquileres++;
        }
    }

    //Método burbuja con cliente por nif
    public void burbujaCliente(EmpresaAlquilerVehiculos aux){
        Cliente auxiliar;
        int valor=0;
        for (int i = 0; i <aux.clientes.length; i++) {
            for (int j =i+1; j <aux.clientes.length; j++) {
                valor=aux.clientes[i].getNif().compareToIgnoreCase(aux.clientes[j].getNif());
                if(valor>0){
                    auxiliar=aux.clientes[i];
                    aux.clientes[i]=aux.clientes[j];
                    aux.clientes[j]=auxiliar;
                }
            }
        }
        
            }
    
    //Método burbuja con vehiculos por matrícula
    public void burbujaVehiculos(EmpresaAlquilerVehiculos aux){
        Vehiculo auxiliar;
        int valor=0;
        for (int i = 0; i <aux.vehiculos.length; i++) {
            for (int j =i+1; j <aux.vehiculos.length; j++) {
                valor=aux.vehiculos[i].getMatricula().compareTo(aux.vehiculos[j].getMatricula());
                if(valor>0){
                    auxiliar=aux.vehiculos[i];
                    aux.vehiculos[i]=aux.vehiculos[j];
                    aux.vehiculos[j]=auxiliar;
                }
            }
        }
    }
    
    //Búsqueda binaria con clientes
    public void busquedaNif(){
        
        Scanner teclado=new Scanner(System.in);
        int mitad;
        int limiteInferior = 0;
        int limiteSuperior = this.clientes.length-1;
        System.out.println("Introduzca nif a buscar");
        String buscado=teclado.nextLine();
        int valor=0;
        boolean encontrado=false;
        
//        int numeroBusqueda = 11;
//        boolean encontrado = false;
//        while ((limiteInferior <= limiteSuperior) && (!encontrado)) {
//            mitad = (limiteInferior + limiteSuperior) / 2;
//            if (numeros[mitad] == numeroBusqueda) {
//                encontrado = true; // ¡encontrado!
//            } else if (numeros[mitad] > numeroBusqueda) {
//                limiteSuperior = mitad - 1; // buscar en la primera mitad
//            } else {
//                limiteInferior = mitad + 1; // buscar en la segunda mitad
//            }
//        }
        
        while((limiteInferior<=limiteSuperior) && (!encontrado)){
            mitad=(limiteInferior + limiteSuperior)/2;
            valor=this.clientes[mitad].getNif().compareTo(buscado);
            if(valor==0){
                encontrado=true;
            }else if(valor>0){
                limiteInferior=mitad-1;
            }else{
                limiteSuperior=mitad-1;
            }
            
            if(encontrado){
                System.out.println("Lo hemos encontrado");
            }else{
                System.out.println("No ha habido suerte");
            }
        }
}
    
    //método recibirVehiculo
    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }

    //getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "EmpresaAlquilerVehiculos{" + "cif=" + cif + ", nombre=" + nombre + ", paginaWeb=" + paginaWeb + ", totalClientes=" + totalClientes + ", clientes=" + clientes + ", totalVehiculos=" + totalVehiculos + ", vehiculos=" + vehiculos + ", totalAlquileres=" + totalAlquileres + ", alquileres=" + alquileres + '}';
    }

    public static void main(String[] args) {
        
        EmpresaAlquilerVehiculos prueba= new EmpresaAlquilerVehiculos("iouiuhi","Rosa","wwww.iowjfjhweof.com");
        

        prueba.rellenarVehiculos(prueba);
        prueba.imprimirVehiculos();
        System.out.println("---------------------------------");
        prueba.rellenarClientes(prueba);

        prueba.rellenarVehiculos();
        prueba.imprimirVehiculos();
        System.out.println("---------------------------------");
        prueba.rellenarClientes();

        prueba.imprimirClientes();
        
        System.out.println("------------------");
        prueba.burbujaCliente(prueba);
        System.out.println("ORDENADOS LOS CLIENTES");
        prueba.imprimirClientes();
        prueba.busquedaNif();
    }
}
