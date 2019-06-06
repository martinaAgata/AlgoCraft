package main;

import main.herramientas.*;
import main.materiales.Diamante;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DiamanteTests {
    @Test
    public void test01CrearDiamante() {
        Diamante diamante = new Diamante();
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test01DiamanteNoEsDesgastadoPorHachaMadera() {
        Diamante diamante = new Diamante();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test02DiamanteNoEsDesgastadoPorHachaPiedra() {
        Diamante diamante = new Diamante();
        HachaPiedra hachaPiedra= new HachaPiedra();
        hachaPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaMetal() {
        Diamante diamante = new Diamante();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorPicoMadera() {
        Diamante diamante = new Diamante();
        PicoMadera picoMadera = new PicoMadera();
        picoMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoPiedra(){
        Diamante diamante = new Diamante();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoMetal(){
        Diamante diamante = new Diamante();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));

    }

    @Test
    public void test07DiamanteEsDesgastadoPorPicoFino(){
        Diamante diamante = new Diamante();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(80));
    }
}

