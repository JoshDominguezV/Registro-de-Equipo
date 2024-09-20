

public class Tablet extends Equipo {
    private String tamañoPantalla;
    private String tipoPantalla; // Capacitiva o Resistiva
    private String memoriaNAND;
    private String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String tamañoPantalla, String tipoPantalla, String memoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador);
        this.tamañoPantalla = tamañoPantalla;
        this.tipoPantalla = tipoPantalla;
        this.memoriaNAND = memoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public Object[] getDatos() {
        return new Object[]{fabricante, modelo, microprocesador, tamañoPantalla, tipoPantalla, memoriaNAND, sistemaOperativo};
    }
}
