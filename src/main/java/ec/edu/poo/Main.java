package ec.edu.poo;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO PRUEBAS UNITARIAS ---");

        GestorActivos gestor = new GestorActivos();
        int puntosAprobados = 0;

        if (gestor.obtenerCantidadActivos() == 0 && gestor.calcularPromedioRiesgo() == 0.0) {
            System.out.println("[OK] Prueba 1: Inicializacion y promedio en vacio correcto.");
            puntosAprobados++;
        }

        Servidor servidorLinux = new Servidor("SRV-01", "Servidor Web", 9, false, "Ubuntu 22.04");
        Firewall firewallCisco = new Firewall("FW-01", "Firewall Perimetral", 7, false, 25);

        if (servidorLinux instanceof ActivoDigital && firewallCisco instanceof ActivoDigital) {
            System.out.println("[OK] Prueba 2: Herencia en Servidor y Firewall correcta.");
            puntosAprobados++;
        }

        boolean reg1 = gestor.registrarActivo(servidorLinux);
        boolean reg2 = gestor.registrarActivo(firewallCisco);

        if (reg1 && reg2 && gestor.obtenerCantidadActivos() == 2) {
            System.out.println("[OK] Prueba 3: Registro basico de activos exitoso.");
            puntosAprobados++;
        }

        Servidor servidorDuplicado = new Servidor("SRV-01", "Servidor Clon", 4, false, "Windows");
        boolean regDuplicado = gestor.registrarActivo(servidorDuplicado);

        if (!regDuplicado && gestor.obtenerCantidadActivos() == 2) {
            System.out.println("[OK] Prueba 4: Control de codigos duplicados correcto.");
            puntosAprobados++;
        }

        ActivoDigital encontrado = gestor.buscarPorCodigo("SRV-01");
        ActivoDigital noEncontrado = gestor.buscarPorCodigo("CODIGO-FALSO");

        if (encontrado != null && encontrado.getNombre().equals("Servidor Web") && noEncontrado == null) {
            System.out.println("[OK] Prueba 5: Busqueda secuencial correcta.");
            puntosAprobados++;
        }

        if (gestor.contarActivosCriticos() == 1) {
            System.out.println("[OK] Prueba 6: Conteo de activos criticos correcto.");
            puntosAprobados++;
        }

        if (gestor.calcularPromedioRiesgo() == 8.0) {
            System.out.println("[OK] Prueba 7: Calculo de promedio aritmetico correcto.");
            puntosAprobados++;
        }

        boolean parcheOk = gestor.aplicarParcheActivo("SRV-01");
        boolean parcheFail = gestor.aplicarParcheActivo("CODIGO-INEXISTENTE");

        if (parcheOk && servidorLinux.isParcheAplicado() && !parcheFail) {
            System.out.println("[OK] Prueba 8: Aplicacion de parches correcta.");
            puntosAprobados++;
        }

        for (int i = 0; i < 8; i++) {
            gestor.registrarActivo(new Servidor("SRV-FILL-" + i, "Servidor de Relleno", 5, false, "Linux"));
        }

        Servidor servidorOnce = new Servidor("SRV-11", "Excedente", 4, false, "Linux");
        boolean regExcedente = gestor.registrarActivo(servidorOnce);

        if (!regExcedente && gestor.obtenerCantidadActivos() == 10) {
            System.out.println("[OK] Prueba 9: Restriccion de capacidad maxima (10) validada.");
            puntosAprobados++;
        }

        gestor.reiniciar();
        if (gestor.obtenerCantidadActivos() == 0 && gestor.obtenerActivos()[0] == null) {
            System.out.println("[OK] Prueba 10: Limpieza y reinicio del gestor completado.");
            puntosAprobados++;
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Pruebas superadas: " + puntosAprobados + " / 10");
    }
}
