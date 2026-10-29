package luchaLibre.DAO;

import luchaLibre.dataBase.DataBaseConnection;
import luchaLibre.modelo.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO implements EmpresaIDAO{
    Connection con = DataBaseConnection.getConnetionDb();

    @Override
    public List<Empresa> listarEmpresas() {
        PreparedStatement ps;
        ResultSet rs;
        List<Empresa> empresas = new ArrayList<>();
        try{
            String sql = "SELECT * FROM lucha_libre.empresas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setPais(rs.getString("pais"));
                empresa.setGerente(rs.getString("presidente"));
                empresa.setEventos(rs.getString("eventos"));
                empresas.add(empresa);
            }

            return empresas;
        }catch (Exception e){
            System.out.println("Error al listar a los luchadores" + e );
        }
        return empresas;
    }

    @Override
    public boolean agregarEmpresa(Empresa emp) {
       PreparedStatement ps;
       String sql = "INSERT INTO lucha_libre.empresas (nombre, pais, presidente, eventos) VALUES (?, ?, ?, ?)";
       try{
           ps  = con.prepareStatement(sql);
           ps.setString(1, emp.getNombre());
           ps.setString(2, emp.getPais());
           ps.setString(3, emp.getGerente());
           ps.setString(4, emp.getEventos());
           ps.executeUpdate();
           return true;

       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }

    @Override
    public boolean modificarInformacion(Empresa emp) {
        PreparedStatement ps;
        try{

            String sql = "UPDATE lucha_libre.empresas SET nombre = ?, pais = ?, presidente = ?, eventos = ? WHERE id_empresa = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPais());
            ps.setString(3,emp.getGerente());
            ps.setString(4, emp.getEventos());
            ps.setInt(5, emp.getIdEmpresa());
            ps.executeUpdate();

            return  true;
        }catch (Exception e){
            System.out.println("Error al modificar la infromación de la empresa: " + e);
        }
        return false;
    }

    @Override
    public boolean eliminarInformacion(Empresa emp) {
        PreparedStatement ps;

        String sql = "DELETE FROM lucha_libre.empresas WHERE id_empresa = ?";
        try{
        ps = con.prepareStatement(sql);
        ps.setInt(1,emp.getIdEmpresa());
        ps.executeUpdate();
            System.out.println("Eliminado con exito");
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean buscarPorId(Empresa emp) {
        PreparedStatement ps;
        ResultSet rs;
        try{
            String sql = "SELECT * FROM lucha_libre.empresas WHERE id_empresa = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,emp.getIdEmpresa());
            rs = ps.executeQuery();
         while(rs.next()){
             emp.setIdEmpresa(rs.getInt("id_empresa"));
             emp.setNombre(rs.getString("nombre"));
             emp.setPais(rs.getString("pais"));
             emp.setGerente(rs.getString("presidente"));
             emp.setEventos(rs.getString("eventos"));
         }
            return true;
        }catch (Exception e ){
            System.out.println("Error al buscar por Id" + e);
        }
        return false;
    }
}
