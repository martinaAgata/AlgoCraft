package modelo.materiales;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.*;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PiedraTests {

    public static final int DURABILIDAD_INICIAL_PIEDRA = 30;

    @Test
    public void testCrearPiedra() {
        Piedra piedra = new Piedra();
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void testPiedraNoEsDesgastadaPorHachaMadera() {
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        piedra.desgastarContra(hachaMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }
    @Test
    public void testPiedraNoEsDesgastadaPorHachaPiedra() {
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        piedra.desgastarContra(hachaPiedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void testPiedraNoEsDesgastadaPorHachaMetal() {
        Piedra piedra = new Piedra();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        piedra.desgastarContra(hachaMetal);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));

    }
    @Test
    public void testPiedraEsDesgastadaPorPicoMadera() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));

    }
    @Test
    public void testPiedraEsDesgastadaPorPicoPiedra() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        piedra.desgastarContra(picoPiedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));

    }
    @Test
    public void testPiedraEsDesgastadaPorPicoMetal() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        piedra.desgastarContra(picoMetal);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void testPiedraNoEsDesgastadaPorPicoFino() {
        Piedra piedra = new Piedra();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        piedra.desgastarContra(picoFino);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA));
    }

    @Test
    public void testPiedraEsDesgastadaPorPicoMaderaSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 2));
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 6));
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
    }

    @Test
    public void testPiedraEsDesgastadaPorPicoPiedraSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        piedra.desgastarContra(picoPiedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 4));
        piedra.desgastarContra(picoPiedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 8));
        piedra.desgastarContra(picoPiedra);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
    }

    @Test
    public void testPiedraEsDesgastadaPorPicoMetalSeReduceVariasVeces() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        piedra.desgastarContra(picoMetal);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 12));
        piedra.desgastarContra(picoMetal);
        assertThat(piedra.getDurabilidad(), is(DURABILIDAD_INICIAL_PIEDRA - 24));
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testPiedraEsDesgastadaPorPicoMaderaLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        for (int i = 0; i < 16; i++){ piedra.desgastarContra(picoMadera); }
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testPiedraEsDesgastadaPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        for (int i = 0; i < 9; i++) { piedra.desgastarContra(picoPiedra); }
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testPiedraEsDesgastadaPorPicoMetalLanzaExcepcionTrasRomperse() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        for (int i=0; i<4; i++){
            piedra.desgastarContra(picoMetal);
        }
    }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testPiedraConEstadoMuertoEsDesgastadaLanzaExcepcion() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        for (int i = 0; i < 15; i++){ piedra.desgastarContra(picoMadera); }
    }

    @Test
    public void testPiedraEsDesgastadaConPicoMaderaPicoPiedraPicoMetal() {
        Piedra piedra = new Piedra();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Integer durabilidadPiedra = piedra.getDurabilidad();
        piedra.desgastarContra(picoMadera);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 2));
        durabilidadPiedra -= picoMadera.getFuerza();
        piedra.desgastarContra(picoPiedra);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 4));
        durabilidadPiedra -= picoPiedra.getFuerza();
        piedra.desgastarContra(picoMetal);
        assertThat(piedra.getDurabilidad(), is(durabilidadPiedra - 12));
    }
}
