package modelo.materiales;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.*;
import modelo.materiales.Madera;
import modelo.materiales.Material;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalTests {

    private static final int DURABILIDAD_INICIAL_METAL = 50;

    @Test
    public void testSeCreaMetalConDurabilidadCorrespondiente() {
        Metal metal = new Metal();
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaMadera() {
        Metal metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        metal.desgastarContra(hachaMadera);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        metal.desgastarContra(hachaPiedra);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        metal.desgastarContra(hachaMetal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        metal.desgastarContra(picoMadera);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void testMetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        metal.desgastarContra(picoPiedra);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
    }
    @Test
    public void testMetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        metal.desgastarContra(picoMetal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        metal.desgastarContra(picoFino);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }

    @Test
    public void testMetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        metal.desgastarContra(picoPiedra);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
        metal.desgastarContra(picoPiedra);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 8));
        metal.desgastarContra(picoPiedra);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 12));
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testMetalEsDesgastadoPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        for (int i = 0; i < 14; i++) { metal.desgastarContra(picoPiedra); }
    }
}
