package interfaz;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import static interfaz.ConstantesInterfaz.*;

public class Inventario extends VBox {
    private HBox hbox = new HBox(10);

    public Inventario() {
        this.crearInventario();
        this.getChildren().add(this.hbox);
    }
    private void crearInventario() {
        this.hbox.setAlignment(Pos.CENTER);
        this.setPrefWidth(480);
        this.hbox.setSpacing(5);
        ImageView madera = new ImageView(new Image(RUTA_IMG_MADERA));
        madera.setFitHeight(40);
        madera.setFitWidth(40);
        ImageView piedra = new ImageView(new Image(RUTA_IMG_PIEDRA));
        piedra.setFitHeight(40);
        piedra.setFitWidth(40);
        ImageView metal = new ImageView(new Image(RUTA_IMG_METAL));
        metal.setFitHeight(40);
        metal.setFitWidth(40);
        ImageView diamante = new ImageView(new Image(RUTA_IMG_DIAMANTE));
        diamante.setFitHeight(40);
        diamante.setFitWidth(40);
        this.hbox.getChildren().addAll(madera, piedra, metal, diamante);
    }
}
