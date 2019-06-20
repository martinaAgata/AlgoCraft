package modelo.materiales;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.herramientas.*;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    private static final int DURABIDAD_INICIAL_MADERA = 10;

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(),is(DURABIDAD_INICIAL_MADERA - hachaMadera.getFuerza()));

    }
    // probar que el reducir durabilidad tambien funciona bien

    @Test
    public void testMaderaEsDesgastadaPorHachaPiedra(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra= constructor.construir();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
    }

    @Test
    public void testMaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test
    public void testMaderaNoEsDesgastadaPorPicoMadera(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        picoMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void testMaderaNoEsDesgastadaPorPicoPiedra(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        picoPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void testMaderaNoEsDesgastadaPorPicoMetal(){
        Madera madera = new Madera();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        picoMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void testMaderaNoEsDesgastadaPorPicoFino(){
        Madera madera = new Madera();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        picoFino.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaSeReduceVariasVeces(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 4));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 6));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 8));
    }

    @Test
    public void testMaderaEsDesgastadaPorHachaPiedraSeReduceVariasVeces(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testMaderaEsDesgastadaPorHachaMaderaLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testMaderaEsDesgastadaPorHachaPiedraLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testMaderaEsDesgastadaPorHachaMetalLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        hachaMetal.usar(madera);
        hachaMetal.usar(madera);
    }

    @Test
    public void testMaderaConEstadoMuertoDevuelveDurabilidadCero(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Hacha hachaMadera = constructor.construir();
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));
    }

    @Test
    public void testMaderaEsDesgastadaConHachaMaderaHachaPiedraHachaMetal(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 2));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 7));
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));//Es cero porque la madera ya estaria rota a este punto.
    }
}
