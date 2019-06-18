package main;

import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import main.herramientas.*;
import main.materiales.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static main.ConstantesJuego.*;

public class DiamanteTests {

    Diamante diamante = new Diamante();

    static final int DURABILIDAD_INICIAL_DIAMANTE = 100;

    @Test
    public void testSeCreaDiamanteConDurabilidadCorrespondiente() {
        Diamante diamante = new Diamante();
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorHachaMadera() {
        Diamante diamante = new Diamante();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaPiedra() {
        Diamante diamante = new Diamante();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra= constructor.construir();
        hachaPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorHachaMetal() {
        Diamante diamante = new Diamante();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        hachaMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoMadera() {
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        picoMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoPiedra() {
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test07DiamanteNoEsDesgastadoPorPicoMetal(){
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));

    }

    @Test
    public void test08DiamanteEsDesgastadoPorPicoFino(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
    }

    @Test
    public void test09DiamanteEsDesgastadoPorPicoFinoSeReduceVariasVeces(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 40));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 60));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 80));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test10DiamanteEsDesgastadoPorPicoFinoLanzaExcepcionTrasRomperse(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(0));
    }

    @Test
    public void test11DiamanteConEstadoMuertoDevuelveDurabilidadCero(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(0));
    }
    
}

