package main;

import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import main.herramientas.*;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static main.ConstantesJuego.*;
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
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void test03PiedraNoEsDesgastadaPorHachaPiedra() {
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test04PiedraNoEsDesgastadaPorHachaMetal() {
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        hachaMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test05PiedraEsDesgastadaPorPicoMadera() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));

    }
    @Test
    public void test06PiedraEsDesgastadaPorPicoPiedra() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));

    }
    @Test
    public void test07PiedraEsDesgastadaPorPicoMetal() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void test08PiedraNoEsDesgastadaPorPicoFino() {
        Piedra piedra = new Piedra();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }

    @Test
    public void test08PiedraEsDesgastadaPorPicoMaderaSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
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
    public void test09PiedraEsDesgastadaPorPicoPiedraSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void test10PiedraEsDesgastadaPorPicoMetalSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 24));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test11PiedraEsDesgastadaPorPicoMaderaLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        for (int i = 0; i < 16; i++){ picoMadera.usar(piedra); }
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test12PiedraEsDesgastadaPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        for (int i = 0; i < 9; i++) { picoPiedra.usar(piedra); }
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test13PiedraEsDesgastadaPorPicoMetalLanzaExcepcionTrasRomperse() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
    }

    @Test
    public void test14PiedraConEstadoMuertoDevuelveDurabilidadCero() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        for (int i = 0; i < 15; i++){ picoMadera.usar(piedra); }
        assertThat(piedra.getDurabilidad(), is(0));
    }

    @Test
    public void test15PiedraEsDesgastadaConPicoMaderaPicoPiedraPicoMetal() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
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
