package modelo.juego;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.exceptions.CasilleroVacioException;
import modelo.exceptions.NoHayHerramientaParaCrearException;
import modelo.herramientas.*;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronHacha;
import modelo.patrones.DetectorPatronPico;
import modelo.patrones.DetectorPatronPicoFino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Supplier;
import static modelo.juego.ConstantesJuego.*;

public class Juego {

    private Mapa mapa = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
    private Jugador jugador;
    private DetectorPatron detectorPatron;
    private Mapa tableroCrafteo = new Mapa(3,3);
    private HashMap<Material, Integer> inventarioMateriales;
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas  = new HashMap<>();
    private Optional<Herramienta> herramientaCreada;

/*
    public Juego() {
        inicializarJuego();

    }
*/

    public void inicializarJugador() {
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        this.jugador = new Jugador(hachaInicial);
        Ubicacion ubicacionJugador = new Ubicacion(1,6);
        this.mapa.ubicarEnCasillero(jugador, ubicacionJugador);
        this.jugador.setUbicacion(ubicacionJugador);
        //   inventarioHerramientas.get(hachaInicial).add(hachaInicial); ESTO DA NULL EXCEPTION POINTER!!
    }


    public void inicializarJuego(){
        inicializarJugador();
        inicializarMapaConMateriales();
        inicializarInventarioMaterial();
        inicializarInventarioHerramienta();
        inicializarPatrones();
        this.tableroCrafteo = new Mapa(CANTIDAD_FILAS_TABLERO_HERRAMIENTAS,CANTIDAD_COLUMNAS_TABLERO_HERRAMIENTAS);
    }
/*
        posicionarNMateriales(this.mapa, CANTIDAD_MADERAS, () -> new Madera());
        posicionarNMateriales(this.mapa, CANTIDAD_PIEDRAS, () -> new Piedra());
        posicionarNMateriales(this.mapa, CANTIDAD_METALES, () -> new Metal());
        posicionarNMateriales(this.mapa, CANTIDAD_DIAMANTES, () -> new Diamante());

    }
*/
    public void inicializarInventarioMaterial() {
        this.inventarioMateriales = new HashMap<>();
        inventarioMateriales.put(new Madera(), 0);
        inventarioMateriales.put(new Metal(), 0);
        inventarioMateriales.put(new Piedra(), 0);
        inventarioMateriales.put(new Diamante(), 0);
    }

     public void inicializarInventarioHerramienta() {
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Madera(),
                DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE_HACHA_MADERA);
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Piedra(),
                DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, DESGASTE_HACHA_PIEDRA);
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Metal(),
                DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, DESGASTE_HACHA_METAL);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Madera(),
                DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, DESGASTE_PICO_MADERA);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Piedra(),
                DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, DESGASTE_PICO_PIEDRA);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Metal(),
                DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, DESGASTE_PICO_METAL);
        agregarHerramientaAinventarioHerramientas(new ConstructorPicoFino(), new Metal(),
                DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO, DESGASTE_PICO_FINO);

    }

    private void agregarHerramientaAinventarioHerramientas(ConstructorHerramientaAbstracto constructor,
                                                           Material material, int durabilidad, int fuerza, EstrategiaDesgaste desgaste){
        constructor.conMaterial(material).conDurabilidad(durabilidad)
                .conDesgaste(desgaste)
                .conFuerza(fuerza);
        inventarioHerramientas.put(constructor.construir(), new ArrayList<>());
    }

    public Mapa obtenerMapa() {
        return this.mapa;
    }

    public Jugador obtenerJugador(){
        return this.jugador;
    }


/*
    private void posicionarNMateriales(Mapa mapa, int n, Supplier<Material> supplier) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasilleroAleatorio(supplier.get());
        }
    }
*/


    private void inicializarPatrones() {
        DetectorPatron dp = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        dp = new DetectorPatronHacha(new Piedra(), () -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir(), dp);
        dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir(), dp);
        dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir(), dp);
        dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .construir(), dp);
        dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir(), dp);
        dp = new DetectorPatronPicoFino(new Piedra(), () -> new ConstructorPicoFino()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir(), dp);
        this.detectorPatron = dp;
    }


    private void detectarHerramientatableroCrafteo() {
        this.herramientaCreada = this.detectorPatron.resolverPatron(this.tableroCrafteo);
    }

    public void ubicarMaterialTableroCrafteo(Ubicacion ubicacion, Material material) {
        this.tableroCrafteo.ubicarEnCasillero(material, ubicacion);
        detectarHerramientatableroCrafteo();
    }

    public void quitarMaterialTableroCrafteo(Ubicacion ubicacion) {
        this.tableroCrafteo.eliminarDeCasillero(ubicacion);
        detectarHerramientatableroCrafteo();
    }

    public Mapa obtenerTableroCrafteo(){
        return this.tableroCrafteo;
    }

    public void crearHerramienta() {
        //ya tenes cosas en el mapa carfteo y decis crear herramienta
        //detectarHerramientatableroCrafteo();
        if (this.herramientaCreada.isEmpty()) throw new NoHayHerramientaParaCrearException("No se puede crear ninguna herramienta con la combinacion actual");
        //Eliminar materiales del inventario
        for(int x=1; x <= CANTIDAD_FILAS_TABLERO_HERRAMIENTAS; x++) {
            for (int y=1; y <= CANTIDAD_COLUMNAS_TABLERO_HERRAMIENTAS; y++) {
                try {
                    Material eliminar = (Material) this.tableroCrafteo.eliminarDeCasillero(new Ubicacion(x,y));

                    this.inventarioMateriales.put(eliminar, this.inventarioMateriales.get(eliminar) - 1);
                } catch (CasilleroVacioException casilleroVacio){/*Hacer nada*/}
            }
        }


        //Agregar al inventario
        inventarioHerramientas.get(herramientaCreada.get()).add(herramientaCreada.get());
    }

    public void jugar() {

    }


    public void inicializarMapaConMateriales() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                this.mapa.ubicarEnCasillero(new Madera(),new Ubicacion(i, j));
            }
        }
        for (int i = 4; i <= 7; i++) {
            for (int j = 4; j <= 7; j++) {
                this.mapa.ubicarEnCasillero(new Piedra(),new Ubicacion(i, j));
            }
        }

        for (int i = 8; i <= 9; i++) {
            for (int j = 8; j <= 9; j++) {
                this.mapa.ubicarEnCasillero(new Metal(),new Ubicacion(i, j));
            }
        }

        for (int i = 10; i <= 10; i++) {
            for (int j = 10; j <= 10; j++) {
                this.mapa.ubicarEnCasillero(new Diamante(),new Ubicacion(i, j));
            }
        }
    }
}