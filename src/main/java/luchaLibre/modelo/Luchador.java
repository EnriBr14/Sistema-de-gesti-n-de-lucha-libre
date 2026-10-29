package luchaLibre.modelo;

public class Luchador {
    private int idLuchador;
    private String nombre;
    private String paisOrigen;
    private float peso;
    private float altura;
    private String tipoLuchador;
    private int idEmpresa;

    public Luchador(){}

    //Contructor para buscar por ID
    public Luchador(int idLuchador){this.idLuchador = idLuchador;}

    //Contrucctor para agregar un nuevo dato
    public Luchador(String nombre, String paisOrigen, float peso, float altura, String tipoLuchador, int idEmpresa){
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.peso= peso;
        this.altura = altura;
        this.tipoLuchador=tipoLuchador;
        this.idEmpresa =idEmpresa;
    }

    //Contructor para modificar informacion
    public Luchador(int idLuchador, String nombre, String paisOrigen, float peso, float altura, String tipoLuchador, int idEmpresa){
        this(nombre,paisOrigen,peso,altura,tipoLuchador,idEmpresa);
        this.idLuchador = idLuchador;
    }

    public int getIdLuchador() {
        return idLuchador;
    }

    public void setIdLuchador(int idLuchador) {
        this.idLuchador = idLuchador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getTipoLuchador() {
        return tipoLuchador;
    }

    public void setTipoLuchador(String tipoLuchador) {
        this.tipoLuchador = tipoLuchador;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    @Override
    public String toString() {
        return "Luchador{" +
                "idLuchador=" + idLuchador +
                ", nombre='" + nombre + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", tipoLuchador='" + tipoLuchador + '\'' +
                ", idEmpresa=" + idEmpresa +
                '}';
    }

}
