package main;

import main.herramientas.ConstructorHacha;
import main.herramientas.Hacha;
import main.herramientas.ConstructorHacha;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static main.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaMetalTests {

    @Test
    public void test12HachaMetalSeUsaContraMaderaReduceSuDurabilidad() {
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
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad() {
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
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad() {
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
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad() {
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
