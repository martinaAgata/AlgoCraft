package test;

import org.junit.Test;

public class HachaDeMaderaTests {

    @Test
    public void test04HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        Material madera = Material nuevaMadera();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(madera);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(metal);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test07HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(material);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());

    }
}

