package interfaz;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.materiales.Material;

public class ImageViewMaterial extends ImageView {
    private Material material;

    public ImageViewMaterial(Image img){ super(img); }

    public void setMaterial(Material material) { this.material = material; }

    public Material getMaterial() { return material; }
}
