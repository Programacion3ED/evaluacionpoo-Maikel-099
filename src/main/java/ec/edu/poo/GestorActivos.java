package ec.edu.poo;

public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        // TODO: inicializar arreglo y contador
    }

    public void reiniciar() {
        // TODO: reiniciar arreglo y contador
    }

    public boolean registrarActivo(ActivoDigital activo) {
        // TODO: registrar si hay espacio y si el código no existe
        return false;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        // TODO: búsqueda secuencial por código
        return null;
    }

    public int contarActivosCriticos() {
        // TODO: contar activos con nivelRiesgo >= 8
        return 0;
    }

    public double calcularPromedioRiesgo() {
        // TODO: calcular promedio de riesgo
        return 0;
    }

    public boolean aplicarParcheActivo(String codigo) {
        // TODO: buscar activo y cambiar parcheAplicado a true
        return false;
    }

    public int obtenerCantidadActivos() {
        return contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return activos;
    }
}
