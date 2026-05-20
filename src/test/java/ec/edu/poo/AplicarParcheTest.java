package ec.edu.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AplicarParcheTest {

    @Test
    void aplicaParcheAActivoExistente() {
        GestorActivos gestor = new GestorActivos();
        Servidor servidor = new Servidor("SV001", "Servidor", 9, false, "Linux");

        gestor.registrarActivo(servidor);

        assertTrue(gestor.aplicarParcheActivo("SV001"));
        assertTrue(servidor.isParcheAplicado());
    }

    @Test
    void retornaFalseSiActivoNoExiste() {
        GestorActivos gestor = new GestorActivos();

        assertFalse(gestor.aplicarParcheActivo("NO_EXISTE"));
    }
}
