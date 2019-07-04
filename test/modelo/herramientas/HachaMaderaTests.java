package modelo.herramientas;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
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


public class HachaMaderaTests {

    @Test
    public void testHachaMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testHachaMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Piedra piedra = new Piedra();
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(98));
   }

    @Test
    public void testHachaMaderaSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Metal metal = new Metal();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testHachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Diamante diamante = new Diamante();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testHachaMaderaSeUsaContraMaderaReduceSuDurabilidadDeADos() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Madera madera = new Madera();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void testHachaMaderaSeUsaContraPiedraReduceSuDurabilidadDeADos() {
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Piedra piedra = new Piedra();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void testHachaMaderaSeUsaContraMetalReduceSuDurabilidadDeADos() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Metal metal = new Metal();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void testHachaMaderaSeUsaContraDiamanteReduceSuDurabilidadDeADos() {
        ConstructorHacha constructor = new ConstructorHacha();
                constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        Diamante diamante = new Diamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testHachaMaderaNoPuedeUsarseRota(){
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);

        Hacha hachaMadera = constructor.construir();
        for (int i = 0; i < 51; i++){
            hachaMadera.usar(piedra);
        }

    }

    @Test
    public void testHachaMaderaEsIgualASiMisma(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertTrue(hachaMadera.esIgualA(hachaMadera));
    }

    @Test
    public void testNuevaHachaMaderaEsIgualANuevaHachaMadera(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Hacha nuevaHachaMadera =  new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertTrue(hachaMadera.esIgualA(nuevaHachaMadera));
    }

    @Test
    public void testHachaMaderaUsadaNOEsIgualANuevaHachaMadera(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        hachaMadera.desgastarContra(new Madera());
        Hacha nuevaHachaMadera =  new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertTrue(hachaMadera.esIgualA(nuevaHachaMadera));
    }

    @Test
    public void testHachaMaderaNOEsIgualAHachaPiedra(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Hacha hachaPiedra = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(hachaMadera.esIgualA(hachaPiedra));
    }

    @Test
    public void testHachaMaderaNOEsIgualAHachaMetal(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Hacha hachaMetal = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(hachaMadera.esIgualA(hachaMetal));
    }

    @Test
    public void testHachaMaderaNOEsIgualAPico(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Pico pico = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertFalse(hachaMadera.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(hachaMadera.esIgualA(pico));
        pico = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertFalse(hachaMadera.esIgualA(pico));
    }

    @Test
    public void testHachaMaderaNOEsIgualAPicoFino(){
        Hacha hachaMadera = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertFalse(hachaMadera.esIgualA(picoFino));
    }
}