package modelo.herramientas;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.herramientas.ConstructorPicoFino;
import modelo.herramientas.PicoFino;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static modelo.juego.ConstantesJuego.FUERZA_PICO_FINO;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class PicoFinoTests {

    private final int DURABILIDAD_PICO_FINO = 1000;
    private final int FUERZA_PICO_FINO = 20;

    @Test
    public void testCrearPicoFinoConDurabilidad() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        assertThat(picoFino.getDurabilidad(), is(1000));
    }

    @Test
    public void testCrearPicoFinoConFuerza() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        assertThat(picoFino.getFuerza(), is(20));
    }

    @Test
    public void testPicoFinoSeUsaContraDiamanteYSeReduceSuDurabilidad() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Diamante diamante = new Diamante();
        picoFino.usar(diamante);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int) (FUERZA_PICO_FINO * 0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraMaderaYNoReduceSuDurabilidad() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Madera madera = new Madera();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int) (FUERZA_PICO_FINO * 0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraMetalYNoReduceSuDurabilidad() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Metal metal = new Metal();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int) (FUERZA_PICO_FINO * 0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Piedra piedra = new Piedra();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int) (FUERZA_PICO_FINO * 0.1))));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoFinoRotoNoSePuedeUsar() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Madera madera = new Madera();
        for (int i = 0; i < 501; i++) {
            picoFino.usar(madera);
        }
    }
    @Test
    public void testPicoFinoEsIgualASiMisma(){
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertTrue(picoFino.esIgualA(picoFino));
    }

    @Test
    public void testNuevoPicoFinoEsIgualANuevoPicoFino(){
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        PicoFino nuevopicoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertTrue(picoFino.esIgualA(nuevopicoFino));
    }

    @Test
    public void testPicoFinoUsadaNOEsIgualANuevoPicoFino(){
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        picoFino.desgastarContra(new Piedra());
        PicoFino nuevapicoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertTrue(picoFino.esIgualA(nuevapicoFino));
    }

    @Test
    public void testPicoFinoNOEsIgualAHacha(){
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        Hacha hacha = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(picoFino.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(picoFino.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertFalse(picoFino.esIgualA(hacha));
    }

    @Test
    public void testPicoFinoNOEsigualAPico(){
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        Pico pico = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertFalse(picoFino.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(picoFino.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertFalse(picoFino.esIgualA(pico));
    }

}
