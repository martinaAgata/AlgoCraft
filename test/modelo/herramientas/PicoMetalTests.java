package modelo.herramientas;

import modelo.estrategias.DesgasteAbrupto;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PicoMetalTests {

    private final int DURABILIDAD_PICO_METAL = 400;
    private final int FUERZA_PICO_METAL = 12;

    private EstrategiaDesgaste desgastePicoMetal;

    @Before
    public void setup() {
        desgastePicoMetal = new DesgasteAbrupto();
    }

    @Test
    public void testCrearPicoDeMetalConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testCrearPicoDeMetalConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMaderaNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraPiedraNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMetalNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }


    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalNoSePuedeUsarRoto() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Madera madera = new Madera();
        for (int i =0; i<11; i++){
            picoMetal.usar(madera);
        }
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraPiedra10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(0);
        Pico picoMetal = constructor.construir();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraDiamante10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Diamante diamante = new Diamante();
        for(int i = 0; i<11;i++){
            picoMetal.usar(diamante);
        }
    }

    @Test
    public void testPicoMetalEsIgualASiMisma(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertTrue(picoMetal.esIgualA(picoMetal));
    }

    @Test
    public void testNuevoPicoMetalEsIgualANuevoPicoMetal(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Pico nuevoPicoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertTrue(picoMetal.esIgualA(nuevoPicoMetal));
    }

    @Test
    public void testPicoMetalUsadaNOEsIgualANuevoPicoMetal(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        picoMetal.desgastarContra(new Piedra());
        Pico nuevaPicoMetal =  new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        assertTrue(picoMetal.esIgualA(nuevaPicoMetal));
    }

    @Test
    public void testPicoMetalNOEsIgualAPicoPiedra(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Pico picoPiedra = new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        assertFalse(picoMetal.esIgualA(picoPiedra));
    }

    @Test
    public void testpicoMetalNOEsIgualAPicoMadera(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Pico picoMadera = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        assertFalse(picoMetal.esIgualA(picoMadera));
    }

    @Test
    public void testPicoMetalNOEsIgualAHacha(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Hacha hacha = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        assertFalse(picoMetal.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        assertFalse(picoMetal.esIgualA(hacha));
        hacha = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        assertFalse(picoMetal.esIgualA(hacha));
    }

    @Test
    public void testPicoMetalNOEsIgualAPicoFino(){
        Pico picoMetal = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        PicoFino picoFino = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        assertFalse(picoMetal.esIgualA(picoFino));
    }

}
