package test;

import main.herramientas.HachaMadera;
import main.herramientas.HachaMetal;
import main.herramientas.HachaPiedra;
import main.herramientas.PicoMadera;
import main.materiales.Material;
import org.junit.Test;

public class MetalTests {
    @Test
    public void test01CrearMetal() {
        Material metal = Material nuevoMetal();
        assertEquals(50, metal.getDurabilidad());
    }
    @Test
    public void test02MetalNoEsDesgastadoPorHachaMadera() {
        Material metal = Material nuevoMetal();
        HachaMadera hachaMadera = new HachaMadera();
        Integer durabilidadMetal = piedra.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = Material nuevoMetal();
        HachaPiedra hachaPiedra = new HachaPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaPiedra.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = Material nuevoMetal();
        HachaMetal hachaMetal = Hacha nuevaHachaDeMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaMetal.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = Material nuevoMetal();
        PicoMadera picoMadera = new PicoMadera();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMadera.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Material metal = Material nuevoMetal();
        PicoPiedra picoPiedra = new PicoPiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoPiedra.usar(metal);
        assertEquals(durabilidadMetal - picoPiedra.getFuerza(), metal.getDurabilidad());
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Material metal = Material nuevoMetal();
        PicoMetal picoMetal = new PicoMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Material metal = Material nuevoMetal();
        PicoFino picoFino = new PicoFino();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoFino.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
}
