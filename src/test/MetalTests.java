package test;

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
        assertThat(metal.getDurabilidad(), is(50));
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
        Material metal = new Metal(50);
        HachaPiedra hachaPiedra = new HachaPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaPiedra.usar(metal);
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal(50);
        HachaMetal hachaMetal = new HachaMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaMetal.usar(metal);
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal(50);
        PicoMadera picoMadera = new PicoMadera();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMadera.usar(metal);
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal(50);
        PicoPiedra picoPiedra = new PicoPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoPiedra.usar(metal);
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal(50);
        PicoMetal picoMetal = new PicoMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMetal.usar(metal);
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal(50);
        PicoFino picoFino = new PicoFino();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoFino.usar(metal);
    }
}
