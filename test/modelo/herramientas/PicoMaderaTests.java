package modelo.herramientas;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Pico;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PicoMaderaTests {
    @Test
    public void testCrearPicoDeMaderaConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void testCrearPicoDeMaderaConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        assertThat(picoMadera.getFuerza(), is(2));
    }

    @Test
    public void testPicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testPicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is(98));


    }

    @Test
    public void testPicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is(98));

    }

    @Test
    public void testPicoDeMaderaSeUsaContraMetalReduceSuDurabilidadDeADos() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is(DURABILIDAD_PICO_MADERA - 2));
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is(DURABILIDAD_PICO_MADERA - 4));
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is(DURABILIDAD_PICO_MADERA - 6));
    }


    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMaderaNoSePuedeUsarRoto() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Metal metal = new Metal();
        for (int i = 0; i < 51; i++) {
            picoMadera.usar(metal);
        }
    }


    @Test
    public void testPicoMaderaEsIgualASiMisma(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertTrue(picoMadera.esIgualA(picoMadera));
    }

    @Test
    public void testNuevoPicoMaderaEsIgualANuevoPicoMadera(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        Pico nuevopicoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertTrue(picoMadera.esIgualA(nuevopicoMadera));
    }

    @Test
    public void testPicoMaderaUsadaNOEsIgualANuevoPicoMadera(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        picoMadera.desgastarContra(new Piedra());
        Pico nuevapicoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertTrue(picoMadera.esIgualA(nuevapicoMadera));
    }

    @Test
    public void testPicoMaderaNOEsIgualAPicoPiedra(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(picoMadera.esIgualA(picoPiedra));
    }

    @Test
    public void testPicoMaderaNOEsIgualAPicoMetal(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertFalse(picoMadera.esIgualA(picoMetal));
    }

    @Test
    public void testPicoMaderaNOEsIgualAHacha(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        Hacha hacha = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(picoMadera.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(picoMadera.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertFalse(picoMadera.esIgualA(hacha));
    }

    @Test
    public void testPicoMaderaNOEsIgualAPicoFino(){
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertFalse(picoMadera.esIgualA(picoFino));
    }

}