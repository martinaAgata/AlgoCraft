package test;

import org.junit.Test;

public class MaderaTests {
    @Test
    public void test01MaderaEsDesgastadaPorHachaMadera(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        madera.usar(hachaMadera);
        assertEquals(durabilidadMadera - 2, madera.getdurabilidad());
    }

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Hacha hachaPiedra = Hacha nuevaHachaPiedra();
        madera.usar(hachaPiedra);
        assertEquals(durabilidadMadera - 5, madera.getdurabilidad());
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Hacha hachaMetal = Hacha nuevaHachaMetal();
        madera.usar(hachaMetal);
        assertEquals(durabilidadMadera - 10, madera.getdurabilidad());
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Pico picoMadera = Pico nuevoPicoMadera();
        madera.usar(picoMadera);
        assertEquals(durabilidadMadera, madera.getdurabilidad());

    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Pico picoPiedra = Pico nuevoPicoPiedra();
        madera.usar(picoPiedra);
        assertEquals(durabilidadMadera, madera.getdurabilidad());
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        Pico picoMetal = Pico nuevoPicoMetal();
        madera.usar(picoMetal);
        assertEquals(durabilidadMadera, madera.getdurabilidad());
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        PicoFino picoFino = PicoFino nuevoPicoFino();
        madera.usar(picoFino);
        assertEquals(durabilidadMadera, madera.getdurabilidad());
    }
}

}
