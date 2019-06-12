package main;

import main.herramientas.*;
import main.materiales.Desgastable;
import main.materiales.Diamante;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaPiedra() {
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorHachaMetal() {
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoMadera() {
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMadera.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoPiedra() {
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void test07DiamanteNoEsDesgastadoPorPicoMetal(){
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));

    }

    @Test
    public void test08DiamanteEsDesgastadoPorPicoFino(){
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
    }

    @Test
    public void test09DiamanteEsDesgastadoPorPicoFinoSeReduceVariasVeces(){
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 40));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 60));
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 80));
    }

    @Test(expected = IllegalStateException.class)
    public void test10DiamanteEsDesgastadoPorPicoFinoLanzaExcepcionTrasRomperse(){
        Diamante diamante = new Diamante();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
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
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        picoFino.usar(diamante);
        assertThat(diamante.getDurabilidad(), is(0));
    }
    
}

