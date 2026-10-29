package luchaLibre.service;

import luchaLibre.DAO.EmpresaDAO;
import luchaLibre.DAO.LuchadorDAO;
import luchaLibre.modelo.Empresa;
import luchaLibre.modelo.Luchador;

import java.util.List;
import java.util.Scanner;

public class Service implements ServiceRpo{
    Scanner sc = new Scanner(System.in);
    EmpresaDAO empresaDAO = new EmpresaDAO();
    LuchadorDAO luchadorDAO = new LuchadorDAO();

    public int luchadorOempresa(){
        System.out.println("1.- Empresas: ");
        System.out.println("2.- Luchadores: ");
        int idEmpresaLuchador = Integer.parseInt(sc.nextLine());
        return idEmpresaLuchador;
    }

    public void listarLuchadorEmpresa(){
        int  opc = luchadorOempresa();

        if(opc == 1){
            List<Empresa> empresas = empresaDAO.listarEmpresas();
            empresas.forEach( e -> {
                System.out.println(e);
            });

        } else if (opc == 2) {
            List<Luchador> luchadores = luchadorDAO.listarLuchadores();
            luchadores.forEach(l -> {
                System.out.println(l);
            });

        }else{
            System.out.println("opcion no valida");
        }
    }

    public void modificarLuchadorEmpresa(){
        int opc = luchadorOempresa();
            if(opc == 1){
                System.out.println("Id de la empresa que deceas modificar");
                int id = Integer.parseInt(sc.nextLine());
                Empresa emp = new Empresa();
                emp.setIdEmpresa(id);
                System.out.println("Nuevo nombre de la empresa:");
                String nombre = sc.nextLine();
                System.out.println("Pais: ");
                String pais = sc.nextLine();
                System.out.println("Gerente general: ");
                String gerente = sc.nextLine();
                System.out.println("Eventos principal");
                String eve = sc.nextLine();

                emp.setNombre(nombre);
                emp.setPais(pais);
                emp.setGerente(gerente);
                emp.setEventos(eve);

                empresaDAO.modificarInformacion(emp);



            } else if ( opc == 2) {
                System.out.println("Id del luchador que deceas modificar");
                int id = Integer.parseInt(sc.nextLine());
                Luchador luch = new Luchador(id);
                luch.setIdLuchador(id);
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

                luch.setNombre(nombre);
                luch.setPaisOrigen(pOrigen);
                luch.setPeso(peso);
                luch.setAltura(altura);
                luch.setTipoLuchador(tipo);
                luch.setIdEmpresa(idEmpresa);


                luchadorDAO.modificarInformacion(luch);
            }


    }

    @Override
    public void buscarPorIdEoL() {
        int opc = luchadorOempresa();
        if(opc==1){
            System.out.println("Id de la empresa que deceas consultar");
            int ide = Integer.parseInt(sc.nextLine());
            Empresa e = new Empresa();
            e.setIdEmpresa(ide);
            empresaDAO.buscarPorId(e);
            System.out.println(e);
        } else if (opc == 2) {
            System.out.println("Dame el Id del luchador o empresa que deceas consultar:");
            int id = Integer.parseInt(sc.nextLine());
            Luchador luchador = new Luchador(id);
            luchadorDAO.buscarPorId(luchador);

            System.out.println(luchador);
        }
    }

    @Override
    public void eliminarPorIdEoL() {
        int opc = luchadorOempresa();

        if(opc == 1){
            System.out.println("Ingresar el ID de la empresa que deceas eliminar:");
            int id = Integer.parseInt(sc.nextLine());
            Empresa em = new Empresa(id);
            empresaDAO.eliminarInformacion(em);

        } else if (opc ==2 ) {
            System.out.println("Ingresa el ID del luchador que deceas eliminar");
            int id = Integer.parseInt(sc.nextLine());
            Luchador lu = new Luchador(id);
            luchadorDAO.eliminarInformacion(lu);
        }

    }


}
