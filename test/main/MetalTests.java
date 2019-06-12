package main;

import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import main.herramientas.*;
import main.materiales.Material;
import main.materiales.Metal;
import org.junit.Test;

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
        Hacha hachaMadera = constructor.construirHachaMadera();
        hachaMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construirHachaPiedra();
        hachaPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
        hachaMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        picoMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        picoFino.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }

    @Test
    public void test09MetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
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
        Pico picoPiedra = constructor.construirPicoPiedra();
        for (int i = 0; i < 14; i++) { picoPiedra.usar(metal); }
    }
}
