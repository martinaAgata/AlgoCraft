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
    public void testConstructorDeHerramientaDevuelveErrorSiNoHayHerramientaParaCrear(){
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.crearHerramienta();
    }
    @Test
    public void testConstructorDeHerramientaCreaUnPicoMaderaCorrectamente(){
        //Madera | Madera | Madera
        //       | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Madera()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(3,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Pico picoMadera = (new ConstructorPico()).construirPicoMadera();
        assertEquals(herramienta, picoMadera);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoPiedraCorrectamente(){
        //Piedra | Piedra | Piedra
        //       | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(3,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Pico picoPiedra= (new ConstructorPico()).construirPicoPiedra();
        assertEquals(herramienta, picoPiedra);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoMetalCorrectamente(){
        //Metal  | Metal  | Metal
        //       | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Metal()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(3,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Pico picoMetal = (new ConstructorPico()).construirPicoMetal();
        assertEquals(herramienta, picoMetal);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnPicoFinoCorrectamente(){
        //Metal  | Metal  | Metal
        //Piedra | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Metal()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(3,1)));
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(1,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        PicoFino picoFino = (new ConstructorPicoFino()).construirPicoFino();
        assertEquals(herramienta, picoFino);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaMaderaCorrectamente(){
        //Madera | Madera |
        //Madera | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Madera()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(1,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Hacha hachaMadera = (new ConstructorHacha()).construirHachaMadera();
        assertEquals(herramienta, hachaMadera);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaPiedraCorrectamente(){
        //Piedra | Piedra |
        //Piedra | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Piedra()), (new Ubicacion(1,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Hacha hachaPiedra = (new ConstructorHacha()).construirHachaPiedra();
        assertEquals(herramienta, hachaPiedra);
    }

    @Test
    public void testConstructorDeHerramientaCreaUnHachaMetalCorrectamente(){
        //Metal  | Metal  |
        //Metal  | Madera |
        //       | Madera |
        ConstructorDeHerramientas constructor = new ConstructorDeHerramientas();
        constructor.insertarMaterial((new Metal()), (new Ubicacion(1,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(2,1)));
        constructor.insertarMaterial((new Metal()), (new Ubicacion(1,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,2)));
        constructor.insertarMaterial((new Madera()), (new Ubicacion(2,3)));
        Herramienta herramienta = constructor.crearHerramienta();
        Hacha hachaMetal = (new ConstructorHacha()).construirHachaMetal();
        assertEquals(herramienta, hachaMetal);
    }
}
