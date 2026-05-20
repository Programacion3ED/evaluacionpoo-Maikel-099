package ec.edu.poo;

public class Firewall extends ActivoDigital {

    private int reglasActivas;

    public Firewall(String codigo, String nombre, int nivelRiesgo,
                    boolean parcheAplicado, int reglasActivas) {
        super(codigo, nombre, nivelRiesgo, parcheAplicado);
        this.reglasActivas = reglasActivas;
    }

    public int getReglasActivas() {

        return 0;
    }

    public void setReglasActivas(int reglasActivas) {
        this.reglasActivas = reglasActivas;
    }
}
