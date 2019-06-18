package main;

import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import main.herramientas.*;
import main.materiales.Madera;
import main.materiales.Material;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static main.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalTests {

    private static final int DURABILIDAD_INICIAL_METAL = 50;

    @Test
    public void testSeCreaMetalConDurabilidadCorrespondiente() {
        Metal metal = new Metal();
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaMadera() {
        Metal metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        hachaMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        picoMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }

    @Test
    public void test09MetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 8));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 12));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test11MetalEsDesgastadoPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        for (int i = 0; i < 14; i++) { picoPiedra.usar(metal); }
    }
}
