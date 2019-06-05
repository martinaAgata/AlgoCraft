package test;

import main.herramientas.HachaMadera;
import main.materiales.Diamante;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DiamanteTests {
    @Test
    public void test01CrearDiamante() {
        Diamante diamante = new Diamante(100);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void test01DiamanteNoEsDesgastadoPorHachaMadera() {
        Diamante diamante = new Diamante();
        Integer durabilidadDiamante = diamante.getDurabilidad();
        HachaMadera hachaMadera = new HachaMadera();
        hachaMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(durabilidadDiamante));
    }

    @Test
    public void test02DiamanteNoEsDesgastadoPorHachaPiedra() {

    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaMetal() {

    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorPicoMadera() {

    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoPiedra(){

    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoMetal(){

    }

    @Test
    public void test07DiamanteEsDesgastadoPorPicoFino(){

    }
}

