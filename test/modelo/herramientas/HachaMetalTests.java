package modelo.herramientas;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Hacha;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HachaMetalTests {

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testHachaMetalSeUsaContraMaderaUnaVezYLaRompe() {
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Madera madera = new Madera();
        hachaMetal.usar(madera);
    }

    @Test
    public void testHachaMetalSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Piedra piedra = new Piedra();
        hachaMetal.usar(piedra);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void testHachaMetalSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Metal metal = new Metal();
        hachaMetal.usar(metal);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void testHachaMetalSeUsaContraDiamanteReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Diamante diamante = new Diamante();
        hachaMetal.usar(diamante);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testHachaMetalNoSePuedeUsarRota() {
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Diamante diamante = new Diamante();
        for (int i = 0; i<81; i++){
            hachaMetal.usar(diamante);
        }
    }
    @Test
    public void testHachaMetalEsIgualASiMisma(){
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertTrue(hachaMetal.esIgualA(hachaMetal));
    }

    @Test
    public void testNuevaHachaMetalEsIgualANuevaHachaMetal(){
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        Hacha nuevaHachaMetal =  new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertTrue(hachaMetal.esIgualA(nuevaHachaMetal));
    }

    @Test
    public void testHachaMetalUsadaNOEsIgualANuevaHachaMetal(){
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        hachaMetal.desgastarContra(new Madera());
        Hacha nuevaHachaMetal =  new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertTrue(hachaMetal.esIgualA(nuevaHachaMetal));
    }

    @Test
    public void testHachaMetalNOEsIgualAHachaPidra(){
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Hacha hachaPiedra = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(hachaMetal.esIgualA(hachaPiedra));
    }

    @Test
    public void testHachaMetalNOEsIgualAHachaMadera(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(hachaMetal.esIgualA(hachaMadera));
    }

    @Test
    public void testHachaMetalNOEsIgualAPico(){
        Hacha hachaMetal =new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        Pico pico = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertFalse(hachaMetal.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(hachaMetal.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertFalse(hachaMetal.esIgualA(pico));
    }

    @Test
    public void testHachaMetalNOEsIgualAPicoFino(){
        Hacha hachaMetal =new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());        
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertFalse(hachaMetal.esIgualA(picoFino));
    }

}
