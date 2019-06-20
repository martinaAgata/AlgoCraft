package modelo;

import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Pico;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.DESGASTE_PICO_PIEDRA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoPiedraTests {

    private final int DURABILIDAD_PICO_PIEDRA = 200;
    private final int FUERZA_PICO_PIEDRA = 4;
    @Test
    public void testCrearPicoDePiedraConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA));
    }
    @Test
    public void testCrearPicoDePiedraConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        assertThat(picoPiedra.getFuerza(), is(FUERZA_PICO_PIEDRA));
    }
    @Test
    public void testPicoDePiedraSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        Madera madera = new Madera();
        picoPiedra.usar(madera);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }
    @Test
    public void testPicoDePiedraSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        Piedra piedra = new Piedra();
        picoPiedra.usar(piedra);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }

    @Test
    public void testPicoDePiedraSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        Metal metal = new Metal();
        picoPiedra.usar(metal);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }
}
