package main;

import main.estrategias.DesgasteLineal;
import main.herramientas.*;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PiedraTests {

    public static final int DURABILIDAD_INICIAL_PIEDRA = 30;

    @Test
    public void test01CrearPiedra() {
        Piedra piedra = new Piedra();
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void test02PiedraNoEsDesgastadaPorHachaMadera() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void test03PiedraNoEsDesgastadaPorHachaPiedra() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test04PiedraNoEsDesgastadaPorHachaMetal() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void test05PiedraEsDesgastadaPorPicoMadera() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));

    }
    @Test
    public void test06PiedraEsDesgastadaPorPicoPiedra() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));

    }
    @Test
    public void test07PiedraEsDesgastadaPorPicoMetal() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));

    }
    @Test
    public void test08PiedraNoEsDesgastadaPorPicoFino() {
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }

    @Test
    public void test08PiedraEsDesgastadaPorPicoMaderaSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 6));
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
    }

    @Test
    public void test09PiedraEsDesgastadaPorPicoPiedraSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void test10PiedraEsDesgastadaPorPicoMetalSeReduceVariasVeces(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 24));
    }

    @Test(expected = IllegalStateException.class)
    public void test11PiedraEsDesgastadaPorPicoMaderaLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        for (int i = 0; i < 16; i++){ picoMadera.usar(piedra); }
    }

    @Test(expected = IllegalStateException.class)
    public void test12PiedraEsDesgastadaPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        for (int i = 0; i < 9; i++) { picoPiedra.usar(piedra); }
    }

    @Test(expected = IllegalStateException.class)
    public void test13PiedraEsDesgastadaPorPicoMetalLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
    }

    @Test
    public void test14PiedraConEstadoMuertoDevuelveDurabilidadCero(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        for (int i = 0; i < 15; i++){ picoMadera.usar(piedra); }
        assertThat(piedra.getDurabilidad(), is(0));
    }

    @Test
    public void test15PiedraEsDesgastadaConPicoMaderaPicoPiedraPicoMetal(){
        Piedra piedra = new Piedra();
<<<<<<< HEAD
        ConstructorPico constructorA = new ConstructorPico();
        Pico picoMadera = constructorA.construirPicoMadera();
        ConstructorPico constructorB = new ConstructorPico();
        Pico picoPiedra = constructorB.construirPicoPiedra();
        ConstructorPico constructorC = new ConstructorPico();
        Pico picoMetal = constructorC.construirPicoMetal();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Integer durabilidadPiedra = piedra.getDurabilidad();
        picoMadera.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 2));
        durabilidadPiedra -= picoMadera.getFuerza();
        picoPiedra.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 4));
        durabilidadPiedra -= picoPiedra.getFuerza();
        picoMetal.usar(piedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 12));
    }
}
