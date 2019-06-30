package interfaz;

import interfaz.handlers.ElegirHerramientaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import modelo.herramientas.Hacha;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;
import modelo.herramientas.PicoFino;
import modelo.materiales.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static interfaz.ConstantesInterfaz.*;
import static javafx.geometry.Pos.CENTER;
import static modelo.juego.ConstantesJuego.*;

public class Inventario extends VBox {
    private HBox hboxMateriales;
    private HBox hboxHerramientas;
    private HashMap<Material, Integer> inventarioMateriales;
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas;

    private Integer cantidadMaderas;
    private Integer cantidadPiedras;
    private Integer cantidadMetales;
    private Integer cantidadDiamantes;

    private final double CASILLERO_WIDTH = 40;
    private final double CASILLERO_HEIGHT = 40;
    public static final Madera madera = new Madera();
    public static final Piedra piedra = new Piedra();
    public static final Metal metal = new Metal();
    public static final Diamante diamante = new Diamante();
    private HashMap<Herramienta, String> rutaImagenPorHerramienta;

    public Inventario(HashMap<Material, Integer> inventarioMateriales,
                      HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas) {
        this.inventarioMateriales = inventarioMateriales;
        this.inventarioHerramientas = inventarioHerramientas;
        hboxHerramientas = new HBox(10);
        hboxMateriales = new HBox(10);
        this.rutaImagenPorHerramienta = new HashMap<>();
        this.cargarImagenPorHerramienta();
        this.crearInventarioMateriales();
        this.crearInventarioHerramientas();
        this.getChildren().add(this.hboxMateriales);
        this.getChildren().add(this.hboxHerramientas);
    }

    private void cargarImagenPorHerramienta(){
        this.rutaImagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera()), RUTA_IMG_HACHA_MADERA);
        this.rutaImagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra()), RUTA_IMG_HACHA_PIEDRA);
        this.rutaImagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal()), RUTA_IMG_HACHA_METAL);
        this.rutaImagenPorHerramienta.put(new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera()), RUTA_IMG_PICO_MADERA);
        this.rutaImagenPorHerramienta.put(new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra()), RUTA_IMG_PICO_PIEDRA);
        this.rutaImagenPorHerramienta.put(new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal()), RUTA_IMG_PICO_METAL);
        this.rutaImagenPorHerramienta.put(new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO), RUTA_IMG_PICO_FINO);

    }

    public void actualizarInventario() {
        this.cantidadMaderas = this.inventarioMateriales.get(madera);
        this.cantidadPiedras = this.inventarioMateriales.get(piedra);
        this.cantidadMetales = this.inventarioMateriales.get(metal);
        this.cantidadDiamantes = this.inventarioMateriales.get(diamante);
    }

    private void crearInventarioMateriales() {
        this.hboxMateriales.setAlignment(CENTER);
        this.setPrefWidth(480);
        this.hboxMateriales.setSpacing(5);
        /*----- Contador Madera -----*/
        ImageView imgMadera = new ImageView(new Image(RUTA_IMG_MADERA));
        imgMadera.setFitHeight(40);
        imgMadera.setFitWidth(40);
        Label contadorMadera = new Label();
        contadorMadera.setFont(new Font(20));
        cantidadMaderas = this.inventarioMateriales.get(new Madera());
        contadorMadera.setText("" + cantidadMaderas);
        contadorMadera.setGraphic(imgMadera);

        /*----- Contador Piedra -----*/
        ImageView imgPiedra = new ImageView(new Image(RUTA_IMG_PIEDRA));
        imgPiedra.setFitHeight(40);
        imgPiedra.setFitWidth(40);
        Label contadorPiedra = new Label();
        contadorPiedra.setFont(new Font(20));
        cantidadPiedras = this.inventarioMateriales.get(new Piedra());
        contadorPiedra.setText("" + cantidadPiedras);
        contadorPiedra.setGraphic(imgPiedra);

        /*----- Contador Metal -----*/
        ImageView imgMetal = new ImageView(new Image(RUTA_IMG_METAL));
        imgMetal.setFitHeight(40);
        imgMetal.setFitWidth(40);
        Label contadorMetal = new Label();
        contadorMetal.setFont(new Font(20));
        cantidadMetales = this.inventarioMateriales.get(new Metal());
        contadorMetal.setText("" + cantidadMetales);
        contadorMetal.setGraphic(imgMetal);

        /*----- Contador Diamante -----*/
        ImageView imgDiamante = new ImageView(new Image(RUTA_IMG_DIAMANTE));
        imgDiamante.setFitHeight(40);
        imgDiamante.setFitWidth(40);
        Label contadorDiamante = new Label();
        contadorDiamante.setFont(new Font(20));
        cantidadDiamantes = this.inventarioMateriales.get(new Diamante());
        contadorDiamante.setText("" + cantidadDiamantes);
        contadorDiamante.setGraphic(imgDiamante);

        this.hboxMateriales.getChildren().addAll(contadorMadera, contadorPiedra, contadorMetal, contadorDiamante);
    }

    private void crearInventarioHerramientas(){
        this.hboxHerramientas.setAlignment(CENTER);
        this.setPrefWidth(480);
        this.hboxHerramientas.setSpacing(7);
        Set<Herramienta> herramientas = this.inventarioHerramientas.keySet();
        for(Herramienta tipoHerramienta : herramientas){
            for(Herramienta herramienta : this.inventarioHerramientas.get(tipoHerramienta)){
                String ruta = this.rutaImagenPorHerramienta.get(herramienta);
                ImageView imgVHerramienta = new ImageView(new Image(ruta, CASILLERO_WIDTH, CASILLERO_HEIGHT, false, true));
                imgVHerramienta.setFitHeight(40);
                imgVHerramienta.setFitWidth(40);
                Label labelHerramientaLife = new Label();
                labelHerramientaLife.setFont(new Font(20));
                Integer durabilidad = herramienta.getDurabilidad();
                labelHerramientaLife.setText(durabilidad.toString());
                labelHerramientaLife.setGraphic(imgVHerramienta);
                labelHerramientaLife.setOnMouseClicked(new ElegirHerramientaHandler(this, herramienta));
                this.hboxHerramientas.getChildren().add(labelHerramientaLife);
            }
        }
    }

    public void actualizarInventarioMateriales(){
        this.hboxMateriales.getChildren().remove(0, this.hboxMateriales.getChildren().size());
        this.crearInventarioMateriales();
    }
    public void actualizarInventarioHerramientas(){
        this.hboxHerramientas.getChildren().remove(0, this.hboxHerramientas.getChildren().size());
        this.crearInventarioHerramientas();
    }

    public void seleccionarHerramientaAUtilizar(Herramienta herramienta){
        ((Tablero)this.getParent()).seleccionarHerramientaAUtilizar(herramienta);
    }
}
