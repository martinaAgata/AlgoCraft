package main;

import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import main.herramientas.*;
import main.materiales.Madera;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    private static final int DURABIDAD_INICIAL_MADERA = 10;

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(),is(DURABIDAD_INICIAL_MADERA - hachaMadera.getFuerza()));

    }
    // probar que el reducir durabilidad tambien funciona bien

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construir();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construir();
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construir();
        picoMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construir();
        picoMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Madera madera = new Madera();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construir();
        picoFino.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test08MaderaEsDesgastadaPorHachaMaderaSeReduceVariasVeces(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 4));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 6));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 8));
    }

    @Test
    public void test09MaderaEsDesgastadaPorHachaPiedraSeReduceVariasVeces(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test10MaderaEsDesgastadaPorHachaMaderaLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test11MaderaEsDesgastadaPorHachaPiedraLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test12MaderaEsDesgastadaPorHachaMetalLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construir();
        hachaMetal.usar(madera);
        hachaMetal.usar(madera);
    }

    @Test
    public void test13MaderaConEstadoMuertoDevuelveDurabilidadCero(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construir();
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
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construir();
        Hacha hachaPiedra = constructor.construir();
        Hacha hachaMetal = constructor.construir();
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 2));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 7));
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));//Es cero porque la madera ya estaria rota a este punto.
    }
}
