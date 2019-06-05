package test;

import org.junit.Test;

public class HachaMaderaTests {

    @Test
    public void test04HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material madera = Material nuevaMadera();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(madera);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(metal);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test07HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(material);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());

    }
}

