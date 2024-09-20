

public class Desktop extends Equipo {
    private String memoria;
    private String tarjetaGrafica;
    private String tamañoTorre;
    private String capacidadDiscoDuro;

    public Desktop(String fabricante, String modelo, String microprocesador, String memoria, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.memoria = memoria;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamañoTorre = tamañoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public Object[] getDatos() {
        return new Object[]{fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro};
    }
}
