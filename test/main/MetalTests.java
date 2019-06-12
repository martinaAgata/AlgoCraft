package main;

import main.herramientas.*;
import main.materiales.Material;
import main.materiales.Metal;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalTests {

    private static final int DURABILIDAD_INICIAL_METAL = 50;

    @Test
    public void testSeCreaMetalConDurabilidadCorrespondiente() {
        Metal metal = new Metal();
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaMadera() {
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = new ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }

    @Test
    public void test09MetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 8));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 12));
    }

    @Test(expected = IllegalStateException.class)
    public void test11MetalEsDesgastadoPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        for (int i = 0; i < 14; i++) { picoPiedra.usar(metal); }
    }
}
