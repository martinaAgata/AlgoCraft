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
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));
    }

    @Test
    public void test02DiamanteNoEsDesgastadoPorHachaMadera() {
        Diamante diamante = new Diamante();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));
    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaPiedra() {
        Diamante diamante = new Diamante();
        HachaPiedra hachaPiedra= new HachaPiedra();
        hachaPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorHachaMetal() {
        Diamante diamante = new Diamante();
        HachaMetal hachaMetal = new HachaMetal();
        hachaMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));
    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoMadera() {
        Diamante diamante = new Diamante();
        PicoMadera picoMadera = new PicoMadera();
        picoMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));
    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoPiedra(){
        Diamante diamante = new Diamante();
        PicoPiedra picoPiedra = new PicoPiedra();
        picoPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));
    }

    @Test
    public void test07DiamanteNoEsDesgastadoPorPicoMetal(){
        Diamante diamante = new Diamante();
        PicoMetal picoMetal = new PicoMetal();
        picoMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE));

    }

    @Test
    public void test08DiamanteEsDesgastadoPorPicoFino(){
        Diamante diamante = new Diamante();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE - PicoFino.FUERZA_PICO_FINO));
    }

    @Test
    public void test09DiamanteEsDesgastadoPorPicoFinoSeReduceVariasVeces(){
        Diamante diamante = new Diamante();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE - PicoFino.FUERZA_PICO_FINO));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE - 2 * PicoFino.FUERZA_PICO_FINO));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE - 3 * PicoFino.FUERZA_PICO_FINO));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(Diamante.DURABILIDAD_DIAMANTE - 4 * PicoFino.FUERZA_PICO_FINO));
    }

    @Test(expected = IllegalStateException.class)
    public void test10DiamanteEsDesgastadoPorPicoFinoLanzaExcepcionTrasRomperse(){
        Diamante diamante = new Diamante();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
    }

    @Test
    public void test11DiamanteConEstadoMuertoDevuelveDurabilidadCero(){
        Diamante diamante = new Diamante();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(0));
    }
    
}

