package ec.edu.poo;

public class Servidor extends ActivoDigital {

    private String sistemaOperativo;

    public Servidor(String codigo, String nombre, int nivelRiesgo,
                    boolean parcheAplicado, String sistemaOperativo) {
        super(codigo, nombre, nivelRiesgo, parcheAplicado);
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getSistemaOperativo() {

        return null;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
}
