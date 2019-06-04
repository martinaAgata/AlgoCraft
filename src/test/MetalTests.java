package test;

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
        Hacha hachaMadera = Hacha nuevaHachadeMadera();
        Integer durabilidadMetal = piedra.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = Material nuevoMetal();
        Hacha hachaPiedra = Hacha nuevaHachaDePiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaPiedra.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = Material nuevoMetal();
        Hacha hachaMetal = Hacha nuevaHachaDeMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        hachaMetal.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = Material nuevoMetal();
        Pico picoMadera = Pico nuevoPicodeMadera();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMadera.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Material metal = Material nuevoMetal();
        Pico picoPiedra = Pico nuevoPicoDePiedra();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoPiedra.usar(metal);
        assertEquals(durabilidadMetal - picoPiedra.getFuerza(), metal.getDurabilidad());
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Material metal = Material nuevoMetal();
        Pico picoMetal = Pico nuevoPicoDeMetal();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Material metal = Material nuevoMetal();
        PicoFino picoFino = PicoFino nuevoPicoFino();
        Integer durabilidadMetal = metal.getDurabilidad();
        picoFino.usar(metal);
        assertEquals(durabilidadMetal, metal.getDurabilidad());
    }
}
