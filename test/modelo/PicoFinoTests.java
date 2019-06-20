package modelo;

import modelo.herramientas.ConstructorPicoFino;
import modelo.herramientas.PicoFino;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.DESGASTE_PICO_FINO;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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
    public void testPicoFinoSeUsaContraDiamanteYSeReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Diamante diamante = new Diamante();
        picoFino.usar(diamante);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraMaderaYNoReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Madera madera = new Madera();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraMetalYNoReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Metal metal = new Metal();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void testPicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        Piedra piedra = new Piedra();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }
}
