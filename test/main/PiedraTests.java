package main;

import main.estrategias.DesgasteLineal;
import main.herramientas.*;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PiedraTests {

    public static final int DURABILIDAD_INICIAL_PIEDRA = 30;

    @Test
    public void test01CrearPiedra() {
        Piedra piedra = new Piedra();
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void test02PiedraNoEsDesgastadaPorHachaMadera() {
        Piedra piedra = new Piedra();
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
        hachaMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void test03PiedraNoEsDesgastadaPorHachaPiedra() {
        Piedra piedra = new Piedra();
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
        hachaPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test04PiedraNoEsDesgastadaPorHachaMetal() {
        Piedra piedra = new Piedra();
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
        hachaMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test05PiedraEsDesgastadaPorPicoMadera() {
        Piedra piedra = new Piedra();
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));

    }
    @Test
    public void test06PiedraEsDesgastadaPorPicoPiedra() {
        Piedra piedra = new Piedra();
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));

    }
    @Test
    public void test07PiedraEsDesgastadaPorPicoMetal() {
        Piedra piedra = new Piedra();
        Pico picoMetal = ConstructorPico.construirPicoMetal();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));

    }
    @Test
    public void test08PiedraNoEsDesgastadaPorPicoFino() {
        Piedra piedra = new Piedra();
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
        picoFino.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }

    @Test
    public void test08PiedraEsDesgastadaPorPicoMaderaSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 6));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
    }

    @Test
    public void test09PiedraEsDesgastadaPorPicoPiedraSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void test10PiedraEsDesgastadaPorPicoMetalSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
        Pico picoMetal = ConstructorPico.construirPicoMetal();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 24));
    }

    @Test(expected = IllegalStateException.class)
    public void test11PiedraEsDesgastadaPorPicoMaderaLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        for (int i = 0; i < 16; i++){ picoMadera.usar(piedra); }
    }

    @Test(expected = IllegalStateException.class)
    public void test12PiedraEsDesgastadaPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        for (int i = 0; i < 9; i++) { picoPiedra.usar(piedra); }
    }

    @Test(expected = IllegalStateException.class)
    public void test13PiedraEsDesgastadaPorPicoMetalLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        Pico picoMetal = ConstructorPico.construirPicoMetal();
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
    }

    @Test
    public void test14PiedraConEstadoMuertoDevuelveDurabilidadCero(){
        Piedra piedra = new Piedra();
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        for (int i = 0; i < 15; i++){ picoMadera.usar(piedra); }
        assertThat(piedra.getDurabilidad(), is(0));
    }

    @Test
    public void test15PiedraEsDesgastadaConPicoMaderaPicoPiedraPicoMetal(){
        Piedra piedra = new Piedra();
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        Pico picoMetal = ConstructorPico.construirPicoMetal();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 2));
        durabilidadPiedra -= picoMadera.getFuerza();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 4));
        durabilidadPiedra -= picoPiedra.getFuerza();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 12));
    }
}
