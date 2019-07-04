package modelo.herramientas;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Pico;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static modelo.juego.ConstantesJuego.FUERZA_PICO_PIEDRA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDePiedraNoSePuedeUsarRoto() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        Madera madera = new Madera();
        for (int i = 0; i < 120; i++) {
            picoPiedra.usar(madera);
        }
    }


    @Test
    public void testPicoPiedraEsIgualASiMisma(){
        Pico picoPiedra = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertTrue(picoPiedra.esIgualA(picoPiedra));
    }

    @Test
    public void testNuevoPicoPiedraEsIgualANuevoPicoPiedra(){
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        Pico nuevopicoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertTrue(picoPiedra.esIgualA(nuevopicoPiedra));
    }

    @Test
    public void testPicoPiedraUsadaNOEsIgualANuevoPicoPiedra(){
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        picoPiedra.desgastarContra(new Piedra());
        Pico nuevapicoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertTrue(picoPiedra.esIgualA(nuevapicoPiedra));
    }

    @Test
    public void testPicoPiedraNOEsIgualAPicoMadera(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(picoPiedra.esIgualA(picoMadera));
    }

    @Test
    public void testPicoPiedraNOEsIgualAPicoMetal(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(picoPiedra.esIgualA(picoMetal));
    }

    @Test
    public void testPicoPiedraNOEsIgualAHacha(){
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        Hacha hacha = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(picoPiedra.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(picoPiedra.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertFalse(picoPiedra.esIgualA(hacha));
    }

    @Test
    public void testPicoPiedraNOEsIgualAPicoFino(){
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertFalse(picoPiedra.esIgualA(picoFino));
    }

}

