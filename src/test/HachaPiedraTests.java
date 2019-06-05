package test;

import org.junit.Test;

public class HachaDePiedraTests {

    @Test
    public void test08HachaPiedraSeUsaContraMaderaReduceSuDurabilidad(){
        HachaPiedra hachaPiedra = HachaPiedra nuevaHachaPiedra ();
        Material madera = Material nuevaMadera();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(madera);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }

    @Test
    public void test09HachaPiedraSeUsaContraPiedraReduceSuDurabilidad(){
        HachaPiedra hachaPiedra = HachaPiedra nuevaHachaPiedra ();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadMaterial = material.getDurabilidad();
        hachaPiedra.usar(piedra);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());

    }

    @Test
    public void test10HachaPiedraSeUsaContraMetalReduceSuDurabilidad(){
        HachaPiedra hachaPiedra = HachaPiedra nuevaHachaPiedra ();
        Material metal = Material nuevoMetal();
        Integer durabilidadMaterial = material.getDurabilidad();
        hachaPiedra.usar(metal);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }

    @Tests
    public void test11HachaPiedraSeUsaContraDiamanteReduceSuDurabilidad(){
        HachaPiedra hachaPiedra = HachaPiedra nuevaHachaPiedra ();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaPiedra = hacHachahetal.gehachaMetalidad();
        hachaPiedra.usar(diamante);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }
}
