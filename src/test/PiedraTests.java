package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.*;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PiedraTests {
    @Test
    public void test01CrearPiedra() {
        Piedra piedra = new Piedra();
        assertThat(piedra.getDurabilidad(), is(piedra.DURABILIDAD_PIEDRA));
    }
    @Test
    public void test02PiedraNoEsDesgastadaPorHachaMadera() {
        Piedra piedra = new Piedra();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA));
    }
    @Test
    public void test03PiedraNoEsDesgastadaPorHachaPiedra() {
        Piedra piedra = new Piedra();
        HachaPiedra hachaPiedra = new HachaPiedra();
        hachaPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA));

    }
    @Test
    public void test04PiedraNoEsDesgastadaPorHachaMetal() {
        Piedra piedra = new Piedra();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA));

    }
    @Test
    public void test05PiedraEsDesgastadaPorPicoMadera() {
        Piedra piedra = new Piedra();
        PicoMadera picoMadera = new PicoMadera();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA - picoMadera.getFuerza()));

    }
    @Test
    public void test06PiedraEsDesgastadaPorPicoPiedra() {
        Piedra piedra = new Piedra();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA - picoPiedra.getFuerza()));

    }
    @Test
    public void test07PiedraEsDesgastadaPorPicoMetal() {
        Piedra piedra = new Piedra();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA - picoMetal.getFuerza()));

    }
    @Test
    public void test08PiedraNoEsDesgastadaPorPicoFino() {
        Piedra piedra = new Piedra();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(Piedra.DURABILIDAD_PIEDRA));

    }
}
