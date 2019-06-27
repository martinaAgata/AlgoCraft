package interfaz;

import interfaz.handlers.CraftearHerramientaHandle;
import interfaz.handlers.SalirCrafteoHandler;
import interfaz.handlers.SeleccionarMaterialCrafteoHandler;
import interfaz.handlers.UbicarMaterialCrafteoHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.herramientas.Herramienta;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;

import java.util.HashMap;

public class CrafteoController {
    private Juego juego;
    private AbrirInterfazCrafteo interfazCrafteo;
    private SeleccionarMaterialCrafteoHandler selecMaterial;
    private UbicarMaterialCrafteoHandler ubicarMaterial;
    private CraftearHerramientaHandle craftearHandle;
    private SalirCrafteoHandler salirHandler;
    private ImageViewMaterial imgVM;
    private HashMap<Material, String> rutasMateriales;

    public CrafteoController(Juego juego){
        this.juego = juego;
        this.interfazCrafteo = new AbrirInterfazCrafteo();
        this.selecMaterial = new SeleccionarMaterialCrafteoHandler(this);
        this.ubicarMaterial = new UbicarMaterialCrafteoHandler(this);
        this.craftearHandle = new CraftearHerramientaHandle(this);
        this.salirHandler = new SalirCrafteoHandler(this);
    }

    public void iniciarInterfaz(){
        this.interfazCrafteo.iniciar(this.selecMaterial, this.ubicarMaterial, this.craftearHandle, this.salirHandler);
        this.interfazCrafteo.actualizarInventarioHbox(this.juego.obtenerInventarioMaterialesJugador(), this.selecMaterial);
    }

    public void vaciarMatrizCrafteo(){
        Mapa tableroCrafteo = this.juego.obtenerTableroCrafteo();
        for(int i=0; i < tableroCrafteo.obtenerCantidadFilas(); i++){
            for(int j=0; j < tableroCrafteo.obtenerCantidadColumnas(); j++){
                try { tableroCrafteo.eliminarDeCasillero(new Ubicacion(i,j)); }
                catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e){ }
                catch (NoSePuedeEliminarPorqueEstaVacioException e) { }
            }
        }
        this.interfazCrafteo.actualizarTableroCrafteoGrid(tableroCrafteo, this.ubicarMaterial);
    }


    public void colocarMaterial(ImageViewMaterial imgVM){
        this.imgVM = imgVM;
    }

    public void setearMaterial(ImageView imgView){
        int x = GridPane.getColumnIndex(imgView);
        int y = GridPane.getRowIndex(imgView);
        x++;    y++; //Correcion de posicion x empezar desde 0.
        try { this.juego.ubicarMaterialTableroCrafteo(new Ubicacion(x, y), this.imgVM.getMaterial()); }
        catch (NullPointerException nException) {return;}
        this.interfazCrafteo.actualizarTableroCrafteoGrid(this.juego.obtenerTableroCrafteo(), this.ubicarMaterial);
        this.imgVM = null;
        this.interfazCrafteo.actualizarHerramientaCrafteable(this.juego.obtenerHerramientaCrafteable());
    }

    public void crearHerramientaCrafteada(){
        this.juego.crearHerramienta();
        this.vaciarMatrizCrafteo();
        this.interfazCrafteo.actualizarHerramientaCrafteable(null);
        this.interfazCrafteo.actualizarInventarioHbox(this.juego.obtenerInventarioMaterialesJugador(), this.selecMaterial);
    }
}
