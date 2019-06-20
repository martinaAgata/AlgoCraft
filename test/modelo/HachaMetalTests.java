package modelo;

import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Hacha;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaMetalTests {

    @Test
    public void testHachaMetalSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Madera madera = new Madera();
        hachaMetal.usar(madera);
        assertThat(hachaMetal.getDurabilidad(), is(395));
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


}
