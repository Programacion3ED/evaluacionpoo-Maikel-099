package ec.edu.poo;

public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        this.activos = new ActivoDigital[10];
        this.contador = 0;
    }

    public void reiniciar() {
        this.activos = new ActivoDigital[10];
        this.contador = 0;
    }

    public boolean registrarActivo(ActivoDigital activo) {
        if (this.contador >= 10) {
            return false;
        }
        if (buscarPorCodigo(activo.getCodigo()) != null) {
            return false;
        }
        this.activos[this.contador] = activo;
        this.contador++;
        return false;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        for (int i = 0; i < this.contador;i++){
            if (this.activos[i].getCodigo().equals(codigo)){
                return this.activos[i];
            }
        }

        return null;
    }

    public int contarActivosCriticos() {
        int criticos = 0;
        for (int i = 0; i < this.contador; i++) {
            if (this.activos[i].getNivelRiesgo() >= 8){
                criticos++;
            }
        }
        return 0;
    }

    public double calcularPromedioRiesgo() {
        if (this.contador == 0){
            return 0.0;
        }
        double sumaRiesgo = 0;
        for (int i = 0; i < this.contador; i++){
            sumaRiesgo += this.activos[i].getNivelRiesgo();
            return sumaRiesgo /this.contador;
        }
        return 0;
    }

    public boolean aplicarParcheActivo(String codigo) {
        ec.edu.poo.ActivoDigital activoDigital = buscarPorCodigo(codigo);
        if (activos != null){
            aplicarParcheActivo(codigo);
            return true;
        }
        return false;
    }

    public int obtenerCantidadActivos() {
        return contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return activos;
    }
}
