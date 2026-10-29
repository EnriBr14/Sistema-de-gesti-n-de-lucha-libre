package luchaLibre.DAO;

import luchaLibre.dataBase.DataBaseConnection;
import luchaLibre.modelo.Empresa;
import luchaLibre.modelo.Luchador;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join {
    Connection con = DataBaseConnection.getConnetionDb();
    PreparedStatement ps;
    ResultSet rs;
    public List<Luchador> empresasLuchador(Empresa emp){
        List<Luchador> empresasLuchado = new ArrayList<>();

        try{

            String sql = "SELECT l.id_luchador, l.nombre, l.paisOrigen, l.peso, l.altura_cm, l.tipoDeLuchador, l.id_empresa FROM lucha_libre.empresas e INNER JOIN lucha_libre.luchadores l ON l.id_empresa = e.id_empresa WHERE e.id_empresa = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpresa());
            rs = ps.executeQuery();
            while (rs.next()){
                Luchador luchador = new Luchador();
                System.out.println("Objeto: " + luchador.getNombre());
                // Cambia estos campos por los atributos reales
                // de tu clase Luchador.
                luchador.setIdLuchador(rs.getInt("id_luchador"));
                luchador.setNombre(rs.getString("nombre"));
                luchador.setPaisOrigen(rs.getString("paisOrigen"));
                luchador.setPeso(rs.getFloat("peso"));
                luchador.setAltura(rs.getFloat("altura_cm"));
                luchador.setTipoLuchador(rs.getString("tipoDeLuchador"));
                luchador.setIdEmpresa(rs.getInt("id_empresa"));

                empresasLuchado.add(luchador);
            }
            return empresasLuchado;
        }catch(Exception e){
            System.out.println("Error al Join");
        }
        return null;
    }
}
