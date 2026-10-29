package luchaLibre.DAO;

import luchaLibre.modelo.Empresa;
import luchaLibre.modelo.Luchador;

import java.util.List;

public interface EmpresaIDAO {
    public List<Empresa> listarEmpresas();
    boolean agregarEmpresa(Empresa emp);
    boolean modificarInformacion(Empresa emp);
    boolean eliminarInformacion(Empresa emp);
    boolean buscarPorId(Empresa emp);
}
