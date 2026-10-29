package luchaLibre;


import luchaLibre.DAO.EmpresaDAO;
import luchaLibre.DAO.EmpresaIDAO;
import luchaLibre.DAO.Join;
import luchaLibre.DAO.LuchadorDAO;
import luchaLibre.dataBase.DataBaseConnection;
import luchaLibre.modelo.Empresa;
import luchaLibre.modelo.Luchador;
import luchaLibre.service.Service;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBaseConnection.getConnetionDb();
        Join joins = new Join();
        LuchadorDAO luchadorDAO = new LuchadorDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        Service service = new Service();
            boolean salir = true;

        while(salir){
            System.out.println("""
                1.- Listar luchadores y empresas registradas
                2.- Buscar luchador o empresa por ID
                3.- Modificar Empresas o luchadores por ID
                4.- Mostrar luchadores por empresas
                5.- Eliminar luchador o empresa
                6.- Agregar un nuevo luchador o empresa
                """);

         int op = Integer.parseInt(sc.nextLine());
         switch (op){
             case 1 -> {
                 System.out.println("Lista de luchadores o empresas registradas");
               service.listarLuchadorEmpresa();

             }
             case 2 -> {
                service.buscarPorIdEoL();
             }
             case 3 -> {
                 System.out.println("Id de la empresa o luchador que deceas modificar: ");
                 service.modificarLuchadorEmpresa();


             }
             case 4 -> {
                 System.out.println("Mostrar luchadores por empresa: ");
                 System.out.println("1.- RAW");
                 System.out.println("2.- SmackDown");
                 System.out.println("3.- AAA");
                 System.out.println("4.- NXT");
                 System.out.println("5.- CMLL");
                 int emp = Integer.parseInt(sc.nextLine());
                 Empresa newEmp = new Empresa();
                 newEmp.setIdEmpresa(emp);
                 List<Luchador> lista = joins.empresasLuchador(newEmp);
                 switch (emp){
                     case 1 -> {
                         System.out.println("RAW");
                     }
                     case 2 ->{
                         System.out.println("SmackDown");
                     }
                     case 3 ->{
                         System.out.println("AAA");
                     }
                     case 4 ->{
                         System.out.println("NXT");
                     }
                     case 5 -> {
                         System.out.println("CMLL");
                     }default -> {
                         System.out.println("Opcion no valida");
                     }
                 }
                 lista.forEach(luchador -> {
                     System.out.println(luchador);
                 });
             }
             case 5 -> {
                 System.out.println("Eliminar un luchador o empresa por ID: ");
                 service.eliminarPorIdEoL();

             }
             case 6 -> {
                 System.out.println("Agregar");
                 System.out.println("1.- Luchador");
                 System.out.println("2.- Empresa");
                 int opc = Integer.parseInt(sc.nextLine());
                 if(opc == 1){
                     System.out.println("Nombre:");
                     String nombre = sc.nextLine();
                     System.out.println("Pais de origen:");
                     String pOrigen = sc.nextLine();
                     System.out.println("Peso: ");
                     float peso = Float.parseFloat(sc.nextLine());
                     System.out.println("Altura en cm: ");
                     float altura = Float.parseFloat(sc.nextLine());
                     System.out.println("Tipo de luchador:");
                     String tipo = sc.nextLine();
                     System.out.println("Id de la empresa");
                     int idEmpresa = Integer.parseInt(sc.nextLine());
                     Luchador newLuchador = new Luchador(nombre,pOrigen,peso,altura,tipo,idEmpresa);
                     luchadorDAO.agregarLuchador(newLuchador);

                 } else if (opc == 2) {
                     System.out.println("Nombre de la empresa:");
                     String nombre = sc.nextLine();
                     System.out.println("Pais:");
                     String pOrigen = sc.nextLine();
                     System.out.println("Presidente:");
                     String presi = sc.nextLine();
                     System.out.println("Eventos");
                     String eventos = sc.nextLine();

                     Empresa newEmpresa = new Empresa(nombre,pOrigen,presi,eventos);
                     empresaDAO.agregarEmpresa(newEmpresa);
                 }
             }
             default -> {
                 System.out.println("Opcion no valida");
             }

         }
        }
    }
}