package modelo.materiales;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.*;
import modelo.materiales.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static modelo.juego.ConstantesJuego.*;

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
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaMadera = constructor.construir();
        diamante.desgastarContra(hachaMadera);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorHachaPiedra() {
        Diamante diamante = new Diamante();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA);
        Hacha hachaPiedra= constructor.construir();
        diamante.desgastarContra(hachaPiedra);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorHachaMetal() {
        Diamante diamante = new Diamante();
        ConstructorHacha constructor = new ConstructorHacha();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL);
        Hacha hachaMetal = constructor.construir();
        diamante.desgastarContra(hachaMetal);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorPicoMadera() {
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        diamante.desgastarContra(picoMadera);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorPicoPiedra() {
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA);
        Pico picoPiedra = constructor.construir();
        diamante.desgastarContra(picoPiedra);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));
    }

    @Test
    public void testDiamanteNoEsDesgastadoPorPicoMetal(){
        Diamante diamante = new Diamante();
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        diamante.desgastarContra(picoMetal);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE));

    }

    @Test
    public void testDiamanteEsDesgastadoPorPicoFino(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        diamante.desgastarContra(picoFino);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
    }

    @Test
    public void testDiamanteEsDesgastadoPorPicoFinoSeReduceVariasVeces(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        diamante.desgastarContra(picoFino);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 20));
        diamante.desgastarContra(picoFino);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 40));
        diamante.desgastarContra(picoFino);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 60));
        diamante.desgastarContra(picoFino);
        assertThat(diamante.getDurabilidad(), is(DURABILIDAD_INICIAL_DIAMANTE - 80));
    }

    @Test(expected = MaterialSeHaGastadoException.class)
    public void testDiamanteEsDesgastadoPorPicoFinoLanzaExcepcionTrasRomperse(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        for(int i = 0; i<7; i++){
            diamante.desgastarContra(picoFino);
        }
        assertThat(diamante.getDurabilidad(), is(0));
    }

    @Test
    public void testDiamanteConEstadoMuertoDevuelveDurabilidadCero(){
        Diamante diamante = new Diamante();
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO);
        PicoFino picoFino = constructor.construir();
        try{
            for(int i = 0; i<6; i++){
                diamante.desgastarContra(picoFino);
            }
        }catch(MaterialSeHaGastadoException e){}
        assertThat(diamante.getDurabilidad(), is(0));
    }
    
}

