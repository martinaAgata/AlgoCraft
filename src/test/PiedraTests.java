package test;

import org.junit.Test;

public class PiedraTests {
    @Test
    public void test01CrearPiedra() {
        Material piedra = Material nuevaPiedra();
        assertEquals(30, piedra.getDurabilidad());
    }
    @Test
    public void test02PiedraNoEsDesgastadaPorHachaMadera() {
        Material piedra = Material nuevaPiedra();
        HachaMadera hachaMadera = new HachaMadera();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
    @Test
    public void test03PiedraNoEsDesgastadaPorHachaPiedra() {
        Material piedra = Material nuevaPiedra();
        HachaPiedra hachaPiedra = new HachaPiedra();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        hachaPiedra.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
    @Test
    public void test04PiedraNoEsDesgastadaPorHachaMetal() {
        Material piedra = Material nuevaPiedra();
        HachaMetal hachaMetal = new HachaMetal();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        hachaMetal.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
    @Test
    public void test05PiedraEsDesgastadaPorPicoMadera() {
        Material piedra = Material nuevaPiedra();
        Pico picoMadera = new PicoMadera();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoMadera.usar(piedra);
        assertEquals(durabilidadPiedra - picoMadera.getFuerza(), piedra.getDurabilidad());
    }
    @Test
    public void test06PiedraEsDesgastadaPorPicoPiedra() {
        Material piedra = Material nuevaPiedra();
        Pico picoPiedra = new PicoPiedra();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoPiedra.usar(piedra);
        assertEquals(durabilidadPiedra - picoPiedra.getFuerza(), piedra.getDurabilidad());
    }
    @Test
    public void test07PiedraEsDesgastadaPorPicoMetal() {
        Material piedra = Material nuevaPiedra();
        Pico picoMetal = new PicoMetal();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoMetal.usar(piedra);
        assertEquals(durabilidadPiedra - picoMetal.getFuerza(), piedra.getDurabilidad());
    }
    @Test
    public void test08PiedraNoEsDesgastadaPorPicoFino() {
        Material piedra = Material nuevaPiedra();
        PicoFino picoFino = new PicoFino();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoFino.usar(piedra);
        assertEquals(durabilidadPiedra, piedra.getDurabilidad());
    }
}
