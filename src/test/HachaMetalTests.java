package test;

import org.junit.Test;

public class HachaDeMetalTests {

    @Test
    public void test12HachaMetalSeUsaContraMaderaReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material madera = Material nuevaMadera;
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(madera);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }

    @Test
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material material = Material
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(piedra);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }

    @Test
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(metal);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }

    @Test
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(diamante);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }


}
