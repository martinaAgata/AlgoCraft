package interfaz;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.herramientas.Herramienta;
import modelo.materiales.Material;

public class ImageViewHerramienta extends ImageView {
    private Herramienta herramienta;

    public ImageViewHerramienta(Image img){ super(img); }

    public void getHerramienta(Herramienta herramienta) { this.herramienta = herramienta; }

    public Herramienta getHerramienta() { return this.herramienta; }
}
