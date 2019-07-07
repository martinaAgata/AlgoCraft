package modelo.materiales;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.*;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    private static final int DURABIDAD_INICIAL_MADERA = 10;

    private Hacha hachaMadera;

    @Before
    public void setUp() {
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        hachaMadera = constructor.construir();
    }

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(),is(DURABIDAD_INICIAL_MADERA - hachaMadera.getFuerza()));

    }

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
        madera.desgastarContra(hachaPiedra);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
    }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testMaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        madera.desgastarContra(hachaMetal);
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
        madera.desgastarContra(picoMadera);
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
        madera.desgastarContra(picoPiedra);
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
        madera.desgastarContra(picoMetal);
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
        madera.desgastarContra(picoFino);
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
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2));
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 4));
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 6));
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 8));
    }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testMaderaEsDesgastadaPorHachaPiedraSeReduceVariasVeces(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        madera.desgastarContra(hachaPiedra);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
        madera.desgastarContra(hachaPiedra);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testMaderaEsDesgastadaPorHachaMaderaLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Hacha hachaMadera = constructor.construir();
        for(int i=0; i<7; i++){
            madera.desgastarContra(hachaMadera);
        }
    }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testMaderaAlMorirLlamaAObservador() {
        List<Ubicacion> ubicaciones = new ArrayList<>();
        Madera madera = new Madera(new Ubicacion(3,3), Optional.of(ubicable -> ubicaciones.add(ubicable.getUbicacion())));
        for(int i=0; i<4 ; i++){
            madera.desgastarContra(hachaMadera);
        }
        // Aun no se llama al observador
        assertThat(ubicaciones.size(), is(0));
        madera.desgastarContra(hachaMadera);
        // Ahora que ya se murio la madera, llama al observador, y lo hizo una sola vez
        assertThat(ubicaciones.size(), is(1));
        // Llamo con la misma madera en la misma ubicacion
        assertThat(ubicaciones.get(0), is(new Ubicacion(3, 3)));
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testMaderaEsDesgastadaPorHachaPiedraLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra = constructor.construir();
        madera.desgastarContra(hachaPiedra);
        madera.desgastarContra(hachaPiedra);
        madera.desgastarContra(hachaPiedra);
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testMaderaEsDesgastadaPorHachaMetalLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        madera.desgastarContra(hachaMetal);
        madera.desgastarContra(hachaMetal);
    }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testMaderaConEstadoMuertoDevuelveDurabilidadCero(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Hacha hachaMadera = constructor.construir();
        for (int i=0; i<5; i++){
            madera.desgastarContra(hachaMadera);
        }
        assertThat(madera.getDurabilidad(), is(0));
    }

    @Test (expected = MaterialSeHaGastadoException.class)
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
        madera.desgastarContra(hachaMadera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 2));
        madera.desgastarContra(hachaPiedra);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 7));
        madera.desgastarContra(hachaMetal);
        assertThat(madera.getDurabilidad(), is(0));//Es cero porque la madera ya estaria rota a este punto.
    }
}
