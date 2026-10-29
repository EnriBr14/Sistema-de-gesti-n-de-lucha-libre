package luchaLibre.DAO;

import luchaLibre.dataBase.DataBaseConnection;
import luchaLibre.modelo.Luchador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LuchadorDAO implements LuchadorIDAO{
    Connection con = DataBaseConnection.getConnetionDb();
    @Override
    public List<Luchador> listarLuchadores() {
        List<Luchador> luchadores = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM lucha_libre.luchadores ORDER BY id_luchador";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //Una vez se realiza el statement

            //instancia de la clase luchador para llenar los datos

            while(rs.next()){
                Luchador luchador = new Luchador();
                luchador.setIdLuchador(rs.getInt("id_luchador"));
                luchador.setNombre(rs.getString("nombre"));
                luchador.setPaisOrigen(rs.getString("paisOrigen"));
                luchador.setPeso(rs.getFloat("peso"));
                luchador.setAltura(rs.getFloat("altura_cm"));
                luchador.setTipoLuchador(rs.getString("tipoDeLuchador"));
                luchador.setIdEmpresa(rs.getInt("id_empresa"));
                luchadores.add(luchador);
            }

            return luchadores;

        }catch (Exception e){
            System.out.println("Error al listar luchadores: " + e);
        }


        return List.of();
    }

    @Override
    public boolean agregarLuchador(Luchador luchador) {
        PreparedStatement ps;
        String sql = "INSERT INTO lucha_libre.luchadores (nombre,paisOrigen,peso,altura_cm,tipoDeLuchador,id_Empresa) VALUES (?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, luchador.getNombre());
            ps.setString(2,luchador.getPaisOrigen());
            ps.setFloat(3, luchador.getPeso());
            ps.setFloat(4, luchador.getAltura());
            ps.setString(5, luchador.getTipoLuchador());
            ps.setInt(6, luchador.getIdEmpresa());
            ps.executeUpdate();
            return true;

        }catch(Exception e ){
            System.out.println("Accion fallida no se pudo agregar al nuevo personaje" + e);
        }

        return false;
    }

    @Override
    public boolean modificarInformacion( Luchador luchador) {
        PreparedStatement ps;
        ResultSet rs;

        try{
                String sql1 = "UPDATE lucha_libre.luchadores SET nombre = ?, paisOrigen = ?, peso = ?, altura_cm = ?, tipoDeLuchador = ?, id_empresa = ? WHERE id_luchador = ?";
                ps = con.prepareStatement(sql1);
                ps.setString(1,luchador.getNombre());
                ps.setString(2, luchador.getPaisOrigen());
                ps.setFloat(3, luchador.getPeso());
                ps.setFloat(4, luchador.getAltura());
                ps.setString(5, luchador.getTipoLuchador());
                ps.setInt(6, luchador.getIdEmpresa());
                ps.setInt(7, luchador.getIdLuchador());
                ps.executeUpdate();
                return true;



        }catch (Exception e){
            System.out.println("Error al modificar la informacion: " + e);
        }
        return false;
    }

    @Override
    public boolean eliminarInformacion(Luchador luchador) {
        PreparedStatement ps;
        try{
            String sql = "DELETE FROM lucha_libre.luchadores WHERE id_luchador = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, luchador.getIdLuchador());
            ps.executeUpdate();
            System.out.println("Eliminado con exito...");
            return true;

        }catch (Exception e){
            System.out.println("Error al eliminar un luchador");
        }
        return false;
    }

    @Override
    public boolean buscarPorId(Luchador luchador) {
        PreparedStatement ps;
        ResultSet rs;
        try{
            String sql = "SELECT * FROM lucha_libre.luchadores WHERE id_luchador = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, luchador.getIdLuchador());
            rs = ps.executeQuery();
            if(rs.next()){
                luchador.setNombre(rs.getString("nombre"));
                luchador.setPaisOrigen(rs.getString("paisOrigen"));
                luchador.setPeso(rs.getFloat("peso"));
                luchador.setAltura(rs.getFloat("altura_cm"));
                luchador.setTipoLuchador(rs.getString("tipoDeLuchador"));
                luchador.setIdEmpresa(rs.getInt("id_empresa"));
                return true;
            }
        }catch (Exception e){

        }


        return false;
    }
}
