package main;

import main.exceptions.NoHayHerramientaParaCrearException;
import main.herramientas.*;
import main.mapa.Ubicacion;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ConstructorDeHerramientasTests {
    @Test (expected = NoHayHerramientaParaCrearException.class)
    public void testConstructorDeHerramientaDevuelveErrorSiNoHayHerramientaParaCrear() {
    }
    
    @Test
    public void testConstructorDeHerramientaCreaUnPicoMaderaCorrectamente() {
        //Madera | Madera | Madera
        //       | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoPiedraCorrectamente() {
        //Piedra | Piedra | Piedra
        //       | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoMetalCorrectamente() {
        //Metal  | Metal  | Metal
        //       | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoFinoCorrectamente(){
        //Metal  | Metal  | Metal
        //Piedra | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaMaderaCorrectamente(){
        //Madera | Madera |
        //Madera | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaPiedraCorrectamente(){
        //Piedra | Piedra |
        //Piedra | Madera |
        //       | Madera |
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaMetalCorrectamente(){
        //Metal  | Metal  |
        //Metal  | Madera |
        //       | Madera |
    }
}
