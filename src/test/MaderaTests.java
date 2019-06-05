package test;

import main.herramientas.PicoPiedra;
import org.junit.Test;

public class MaderaTests {
    @Test
    public void test01MaderaEsDesgastadaPorHachaMadera(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        HachaMadera hachaMadera = new HachaMadera();
        madera.usar(hachaMadera);
        assertEquals(durabilidadMadera - 2, madera.getDurabilidad());
    }

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        HachaPiedra hachaPiedra = new HachaPiedra();
        madera.usar(hachaPiedra);
        assertEquals(durabilidadMadera - 5, madera.getDurabilidad());
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getdurabilidad();
        HachaMetal hachaMetal = new HachaMetal();
        madera.usar(hachaMetal);
        assertEquals(durabilidadMadera - 10, madera.getdurabilidad());
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        PicoMadera picoMadera = new PicoMadera();
        madera.usar(picoMadera);
        assertEquals(durabilidadMadera, madera.getDurabilidad());

    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        PicoPiedra picoPiedra = new PicoPiedra();
        madera.usar(picoPiedra);
        assertEquals(durabilidadMadera, madera.getDurabilidad());
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        PicoMetal picoMetal = new PicoMetal();
        madera.usar(picoMetal);
        assertEquals(durabilidadMadera, madera.getDurabilidad());
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Material madera = Material nuevaMadera();
        Integer durabilidadMadera = madera.getDurabilidad();
        PicoFino picoFino = new PicoFino();
        madera.usar(picoFino);
        assertEquals(durabilidadMadera, madera.getDurabilidad());
    }
}

}
