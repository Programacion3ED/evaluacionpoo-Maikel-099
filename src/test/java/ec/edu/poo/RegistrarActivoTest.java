package ec.edu.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrarActivoTest {

    @Test
    void registraActivoSiHayEspacioYNoExisteCodigo() {
        GestorActivos gestor = new GestorActivos();
        Servidor servidor = new Servidor("SV001", "Servidor Web", 9, false, "Linux");

        assertTrue(gestor.registrarActivo(servidor));
        assertEquals(1, gestor.obtenerCantidadActivos());
        assertSame(servidor, gestor.obtenerActivos()[0]);
    }

    @Test
    void noRegistraCodigoDuplicado() {
        GestorActivos gestor = new GestorActivos();

        assertTrue(gestor.registrarActivo(new Servidor("SV001", "Servidor Web", 9, false, "Linux")));
        assertFalse(gestor.registrarActivo(new Firewall("SV001", "Firewall", 5, false, 50)));
        assertEquals(1, gestor.obtenerCantidadActivos());
    }
}
