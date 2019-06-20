package modelo.herramientas;

import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Pico;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.DESGASTE_PICO_METAL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMetalTests {

    private final int DURABILIDAD_PICO_METAL = 400;
    private final int FUERZA_PICO_METAL = 12;
    public void test01CrearPicoDeMetalConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testCrearPicoDeMetalConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
}
