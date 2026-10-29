package luchaLibre.DAO;

import luchaLibre.modelo.Luchador;

import java.util.List;

public interface LuchadorIDAO {
    public List<Luchador> listarLuchadores();
    boolean agregarLuchador(Luchador luchador);
    boolean modificarInformacion(Luchador luchador);
    boolean eliminarInformacion(Luchador luchador);
    boolean buscarPorId(Luchador luchador);

}
