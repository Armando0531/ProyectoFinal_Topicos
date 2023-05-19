package modelo;
public class Donacion {
    private int id;
    private int donanteId;
    private int eventoId;
    private double cantidadGarantizada;
    private double cantidadEnviada;
    private String fechaGarantia;
    private int numeroPagos;
    private String tarjetaCredito;
    private String corporacionEmisora;
    private String direccionCorporacion;
    private String nombreConyuge;

    public Donacion(){

    }
    public Donacion(int id, int donanteId, int eventoId, double cantidadGarantizada, double cantidadEnviada,
                    String fechaGarantia, int numeroPagos, String tarjetaCredito, String corporacionEmisora,
                    String direccionCorporacion, String nombreConyuge) {
        this.id = id;
        this.donanteId = donanteId;
        this.eventoId = eventoId;
        this.cantidadGarantizada = cantidadGarantizada;
        this.cantidadEnviada = cantidadEnviada;
        this.fechaGarantia = fechaGarantia;
        this.numeroPagos = numeroPagos;
        this.tarjetaCredito = tarjetaCredito;
        this.corporacionEmisora = corporacionEmisora;
        this.direccionCorporacion = direccionCorporacion;
        this.nombreConyuge = nombreConyuge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonanteId() {
        return donanteId;
    }

    public void setDonanteId(int donanteId) {
        this.donanteId = donanteId;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public double getCantidadGarantizada() {
        return cantidadGarantizada;
    }

    public void setCantidadGarantizada(double cantidadGarantizada) {
        this.cantidadGarantizada = cantidadGarantizada;
    }

    public double getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(double cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public String getFechaGarantia() {
        return fechaGarantia;
    }

    public void setFechaGarantia(String fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    public int getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(int numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCorporacionEmisora() {
        return corporacionEmisora;
    }

    public void setCorporacionEmisora(String corporacionEmisora) {
        this.corporacionEmisora = corporacionEmisora;
    }

    public String getDireccionCorporacion() {
        return direccionCorporacion;
    }

    public void setDireccionCorporacion(String direccionCorporacion) {
        this.direccionCorporacion = direccionCorporacion;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", donanteId=" + donanteId +
                ", eventoId=" + eventoId +
                ", cantidadGarantizada=" + cantidadGarantizada +
                ", cantidadEnviada=" + cantidadEnviada +
                ", fechaGarantia=" + fechaGarantia +
                ", numeroPagos=" + numeroPagos +
                ", tarjetaCredito='" + tarjetaCredito + '\'' +
                ", corporacionEmisora='" + corporacionEmisora + '\'' +
                ", direccionCorporacion='" + direccionCorporacion + '\'' +
                ", nombreConyuge='" + nombreConyuge + '\'' +
                '}';
    }

}
