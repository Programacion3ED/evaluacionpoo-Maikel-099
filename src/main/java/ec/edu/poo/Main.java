package ec.edu.poo;

public class Main {
    public static void main(String[] args) {

        GestorActivos gestor = new GestorActivos();


        Servidor srv1 = new Servidor("SRV-01", "Servidor Web Principal", 5, true, "Linux");
        Servidor srv2 = new Servidor("SRV-02", "Base de Datos", 9, false, "Windows Server");
        Firewall fw1 = new Firewall("FW-01", "Firewall Perimetral", 8, false, 150);

        System.out.println("PRUEBA DE REGISTRO");
        System.out.println("Registro SRV-01: " + gestor.registrarActivo(srv1));
        System.out.println("Registro SRV-02: " + gestor.registrarActivo(srv2));
        System.out.println("Registro FW-01: " + gestor.registrarActivo(fw1));

        System.out.println("\n PRUEBA DE DUPLICADOS");
        Servidor srvDuplicado = new Servidor("SRV-01", "Clon", 4, false, "Linux");
        System.out.println("Registrando duplicado SRV-01: " + gestor.registrarActivo(srvDuplicado));

        System.out.println("\n PRUEBA DE REGLAS DE NEGOCIO ");

        System.out.println("Cantidad de activos críticos: " + gestor.contarActivosCriticos());


        System.out.println("Promedio de riesgo: " + gestor.calcularPromedioRiesgo());

        System.out.println("\n PRUEBA DE PARCHES");
        System.out.println("Estado parche SRV-02 antes: " + srv2.isParcheAplicado());
        System.out.println("Aplicando parche a SRV-02: " + gestor.aplicarParcheActivo("SRV-02"));
        System.out.println("Estado parche SRV-02 después: " + srv2.isParcheAplicado());

        System.out.println("Aplicando parche : " + gestor.aplicarParcheActivo("ERROR-404"));

        System.out.println("\n PRUEBA DE LÍMITE DE CAPACIDAD ");

        for (int i = 1; i <= 8; i++) {
            Firewall fwTest = new Firewall("TEST-" + i, "Test", 1, true, 10);
            boolean resultado = gestor.registrarActivo(fwTest);
            System.out.println("Registrando TEST-" + i + ": " + resultado);
        }

        System.out.println("\nTotal de activos finalmente registrados: " + gestor.obtenerCantidadActivos());
    }
}
