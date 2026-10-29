package luchaLibre.modelo;

public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String pais;
    private String gerente;
    private String eventos;

    public Empresa(){}

    //Constructor que nos va servir para buscar
    public Empresa(int idEmpresa){this.idEmpresa = idEmpresa;}

    //Contructor que nos va a servir para agregar un nuevo dato
    public Empresa(String nombre, String pais, String gerente, String eventos){
        this.nombre = nombre;
        this.pais = pais;
        this.gerente = gerente;
        this.eventos = eventos;
    }

    //Contructor que nos va a servir para modificar por medio del ID
    public Empresa(int idEmpresa, String nombre, String pais, String gerente, String eventos) {
        this(nombre, pais, gerente, eventos);
        this.idEmpresa = idEmpresa;
    }

    //Getter and Setter

    public int getIdEmpresa(){return idEmpresa;}
    public void setIdEmpresa(int idEmpresa){this.idEmpresa = idEmpresa;}


    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEventos() {return eventos;}
    public void setEventos(String eventos) {this.eventos = eventos;}

    public String getGerente() {return gerente;}
    public void setGerente(String gerente) {this.gerente = gerente;}

    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", gerente='" + gerente + '\'' +
                ", eventos='" + eventos + '\'' +
                '}';
    }
}
