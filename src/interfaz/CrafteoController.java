package interfaz;

import interfaz.handlers.CraftearHerramientaHandle;
import interfaz.handlers.SeleccionarMaterialCrafteoHandler;
import interfaz.handlers.UbicarMaterialCrafteoHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;

import java.util.HashMap;

public class CrafteoController {
    private Juego juego;
    private AbrirInterfazCrafteo interfazCrafteo;
    private SeleccionarMaterialCrafteoHandler selecMaterial;
    private UbicarMaterialCrafteoHandler ubicarMaterial;
    private CraftearHerramientaHandle craftearHandle;
    private ImageViewMaterial imgVM;
    private HashMap<Material, String> rutasMateriales;
    public CrafteoController(Juego juego){
        this.juego = juego;
        this.interfazCrafteo = new AbrirInterfazCrafteo();
        this.selecMaterial = new SeleccionarMaterialCrafteoHandler(this);
        this.ubicarMaterial = new UbicarMaterialCrafteoHandler(this);
        this.craftearHandle = new CraftearHerramientaHandle(this);
    }

    public void iniciarInterfaz(){
        this.interfazCrafteo.iniciar(this.selecMaterial, this.ubicarMaterial, this.craftearHandle);
        //this.interfazCrafteo.actualizarInventarioHbox(this.juego.obtenerInventarioMaterialesJugador(), this.selecMaterial);
    }


    public void colocarMaterial(ImageViewMaterial imgVM){
        this.imgVM = imgVM;
    }

    public void setearMaterial(ImageView imgView){
        int y = GridPane.getColumnIndex(imgView);
        int x = GridPane.getRowIndex(imgView);
        x++;    y++; //Correcion de posicion x empezar desde 0.
        try { this.juego.ubicarMaterialTableroCrafteo(new Ubicacion(x, y), this.imgVM.getMaterial()); }
        catch (NullPointerException nException) {return;}
        this.interfazCrafteo.actualizarTableroCrafteoGrid(this.juego.obtenerTableroCrafteo(), this.ubicarMaterial);
    }
}
