package main;

import main.herramientas.*;
import main.materiales.Material;
import main.materiales.Metal;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalTests {
    @Test
    public void test01CrearMetal() {
        Metal metal = new Metal();
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL));
    }
    @Test
    public void test02MetalNoEsDesgastadoPorHachaMadera() {
        Metal metal = new Metal();
        HachaMadera hachaMadera = new HachaMadera();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
        HachaPiedra hachaPiedra = new HachaPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
        HachaMetal hachaMetal = new HachaMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
        PicoMadera picoMadera = new PicoMadera();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
        PicoPiedra picoPiedra = new PicoPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal - PicoPiedra.FUERZA_PICO_PIEDRA));
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
        PicoMetal picoMetal = new PicoMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
        PicoFino picoFino = new PicoFino();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoFino.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal));
    }

    @Test
    public void test09MetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL - PicoPiedra.FUERZA_PICO_PIEDRA));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL - 2 * PicoPiedra.FUERZA_PICO_PIEDRA));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL - 3 * PicoPiedra.FUERZA_PICO_PIEDRA));
    }

    @Test
    public void test10MetalEsDesgastadoPorPicoMetalSeReduceVariasVeces(){
        Metal metal = new Metal();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL - PicoMetal.FUERZA_PICO_METAL));
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL - 2 * PicoMetal.FUERZA_PICO_METAL));
    }

    @Test(expected = IllegalStateException.class)
    public void test11MetalEsDesgastadoPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
        PicoPiedra picoPiedra = new PicoPiedra();
        for (int i = 0; i < 14; i++) { picoPiedra.usar(metal); }
    }

    @Test(expected = IllegalStateException.class)
    public void test12MetalEsDesgastadoPorPicoMetalLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
        PicoMetal picoMetal = new PicoMetal();
        for (int i = 0; i < 5; i++) { picoMetal.usar(metal); }
    }

    @Test
    public void test13MetalEsDesgastadoPorPicoPiedraYPicoMetal(){
        Metal metal = new Metal();
        PicoPiedra picoPiedra = new PicoPiedra();
        PicoMetal picoMetal = new PicoMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal - PicoPiedra.FUERZA_PICO_PIEDRA));
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(durabilidadMetal - PicoPiedra.FUERZA_PICO_PIEDRA - PicoMetal.FUERZA_PICO_METAL));
    }

}
