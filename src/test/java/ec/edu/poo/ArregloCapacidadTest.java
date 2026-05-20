package ec.edu.poo;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

public class ArregloCapacidadTest {

    @Test
    void gestorUsaArregloDeActivosNoEstatico() throws Exception {
        Field activos = GestorActivos.class.getDeclaredField("activos");

        assertTrue(activos.getType().isArray());
        assertEquals(ActivoDigital.class, activos.getType().getComponentType());
        assertFalse(Modifier.isStatic(activos.getModifiers()));
    }

    @Test
    void noPermiteRegistrarMasDeDiezActivos() {
        GestorActivos gestor = new GestorActivos();

        for (int i = 1; i <= 10; i++) {
            assertTrue(
                    gestor.registrarActivo(new ActivoDigital("AD" + i, "Activo " + i, i, false))
            );
        }

        assertFalse(
                gestor.registrarActivo(new ActivoDigital("AD11", "Activo 11", 5, false))
        );

        assertEquals(10, gestor.obtenerCantidadActivos());
    }

    @Test
    void dosGestoresTienenEstadosIndependientes() {
        GestorActivos gestor1 = new GestorActivos();
        GestorActivos gestor2 = new GestorActivos();

        gestor1.registrarActivo(new ActivoDigital("AD001", "Activo 1", 5, false));

        assertEquals(1, gestor1.obtenerCantidadActivos());
        assertEquals(0, gestor2.obtenerCantidadActivos());
    }
}
