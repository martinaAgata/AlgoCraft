package main;

import main.herramientas.*;
import main.materiales.Madera;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    private static final int DURABIDAD_INICIAL_MADERA = 10;

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(),is(DURABIDAD_INICIAL_MADERA - hachaMadera.getFuerza()));

    }
    // hay que probar qeu el reducir durabilidad tmb funciona bien

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Madera madera = new Madera();
        HachaPiedra hachaPiedra = new HachaPiedra();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - hachaPiedra.getFuerza()));
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        Integer durabilidadMadera = madera.getDurabilidad();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - hachaMetal.getFuerza()));
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Madera madera = new Madera();
        PicoMadera picoMadera = new PicoMadera();
        picoMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Madera madera = new Madera();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Madera madera = new Madera();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Madera madera = new Madera();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test08MaderaEsDesgastadaPorHachaMaderaSeReduceVariasVeces(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - HachaMadera.getFuerza()));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2 * HachaMadera.getFuerza()));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 3 * HachaMadera.getFuerza()));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 4 * HachaMadera.getFuerza()));
    }

    @Test
    public void test09MaderaEsDesgastadaPorHachaPiedraSeReduceVariasVeces(){
        Madera madera = new Madera();
        HachaPiedra hachaPiedra = new HachaPiedra();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - HachaPiedra.getFuerza()));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2 * HachaPiedra.getFuerza()));
    }

    @Test(expected = IllegalStateException.class)
    public void test10MaderaEsDesgastadaPorHachaMaderaLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
    }

    @Test(expected = IllegalStateException.class)
    public void test11MaderaEsDesgastadaPorHachaPiedraLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        HachaPiedra hachaPiedra = new HachaPiedra();
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
    }

    @Test(expected = IllegalStateException.class)
    public void test12MaderaEsDesgastadaPorHachaMetalLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(madera);
        hachaMetal.usar(madera);
    }

    @Test
    public void test13MaderaConEstadoMuertoDevuelveDurabilidadCero(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));
    }

    @Test
    public void test15MaderaEsDesgastadaConHachaMaderaHachaPiedraHachaMetal(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        HachaPiedra hachaPiedra = new HachaPiedra();
        HachaMetal hachaMetal = new HachaMetal();
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - HachaMadera.getFuerza()));
        durabilidadMadera -= hachaMadera.getFuerza();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - HachaPiedra.getFuerza()));
        durabilidadMadera -= hachaPiedra.getFuerza();
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));//Es cero porque la madera ya estaria rota a este punto.
    }
}
