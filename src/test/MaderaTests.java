package test;

import main.herramientas.*;
import main.materiales.Madera;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    @Test
    public void test01MaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(),is(Madera.DURABILIDAD_MADERA - hachaMadera.getFuerza()));

    }
    // hay que probar qeu el reducir durabilidad tmb funciona bien

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Madera madera = new Madera();
        HachaPiedra hachaPiedra = new HachaPiedra();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(Madera.DURABILIDAD_MADERA - hachaPiedra.getFuerza()));
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        Integer durabilidadMadera = madera.getDurabilidad();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(Madera.DURABILIDAD_MADERA - hachaMetal.getFuerza()));
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Madera madera = new Madera();
        PicoMadera picoMadera = new PicoMadera();
        picoMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(madera.DURABILIDAD_MADERA));
    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Madera madera = new Madera();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(madera.DURABILIDAD_MADERA));
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Madera madera = new Madera();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(madera.DURABILIDAD_MADERA));
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Madera madera = new Madera();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(madera);
        assertThat(madera.getDurabilidad(), is(madera.DURABILIDAD_MADERA));
    }
}
