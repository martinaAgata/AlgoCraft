package interfaz;

import interfaz.handlers.CraftearHerramientaHandle;
import interfaz.handlers.SalirCrafteoHandler;
import interfaz.handlers.SeleccionarMaterialCrafteoHandler;
import interfaz.handlers.UbicarMaterialCrafteoHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoHayHerramientaParaCrearException;
import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
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
    private HashMap<Material, Integer> inventarioMaterialJugadorCopy;
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
        this.inventarioMaterialJugadorCopy = (HashMap<Material, Integer>) this.juego.obtenerInventarioMaterialesJugador().clone();
    }

    public void vaciarMatrizCrafteo(){
        Mapa tableroCrafteo = this.juego.obtenerTableroCrafteo();
        for(int i=1; i <= tableroCrafteo.obtenerCantidadFilas(); i++){
            for(int j=1; j <= tableroCrafteo.obtenerCantidadColumnas(); j++){
                try { tableroCrafteo.eliminarDeCasillero(new Ubicacion(i,j)); }
                //catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e){ }
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
        try {
            this.juego.ubicarMaterialTableroCrafteo(new Ubicacion(x, y), this.imgVM.getMaterial());
            Integer cantMaterial = this.inventarioMaterialJugadorCopy.get(imgVM.getMaterial());
            if(cantMaterial > 0)this.inventarioMaterialJugadorCopy.put(imgVM.getMaterial(), cantMaterial - 1);
        }
        catch (NullPointerException nException) {return;}
        this.interfazCrafteo.actualizarTableroCrafteoGrid(this.juego.obtenerTableroCrafteo(), this.ubicarMaterial);
        this.interfazCrafteo.actualizarHerramientaCrafteable(this.juego.obtenerHerramientaCrafteable());
        this.interfazCrafteo.actualizarInventarioHbox(this.inventarioMaterialJugadorCopy, this.selecMaterial);
        this.imgVM = null;
    }

    public void crearHerramientaCrafteada(){
        this.interfazCrafteo.actualizarHerramientaCrafteable(null);
        this.vaciarMatrizCrafteo();
        this.interfazCrafteo.actualizarInventarioHbox(this.juego.obtenerInventarioMaterialesJugador(), this.selecMaterial);
        try { this.juego.crearHerramienta(); }
        catch (NoHayHerramientaParaCrearException e) { return; }
    }
}
