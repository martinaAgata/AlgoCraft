package main;

import main.herramientas.ConstructorPico;
import main.herramientas.Pico;
import main.herramientas.ConstructorPico;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static main.ConstantesJuego.DESGASTE_PICO_PIEDRA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoPiedraTests {

    private final int DURABILIDAD_PICO_PIEDRA = 200;
    private final int FUERZA_PICO_PIEDRA = 4;
    @Test
    public void test01CrearPicoDePiedraConDurabilidad() {
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
    public void test02CrearPicoDePiedraConFuerza() {
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
    public void test03PicoDePiedraSeUsaContraMaderaReduceSuDurabilidad() {
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
    public void test04PicoDePiedraSeUsaContraPiedraReduceSuDurabilidad() {
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
    public void test05PicoDePiedraSeUsaContraMetalReduceSuDurabilidad() {
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
