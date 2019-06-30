package interfaz.handlers;

import interfaz.ImageViewHerramienta;
import interfaz.Inventario;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.herramientas.Herramienta;

import javax.swing.text.html.ImageView;

public class ElegirHerramientaHandler implements EventHandler {
    private Inventario inventario;
    private Herramienta herramienta;

    public ElegirHerramientaHandler(Inventario inventario, Herramienta herramienta){
        super();
        this.inventario = inventario;
        this.herramienta = herramienta;
    }
    @Override
    public void handle(Event event) {
        System.out.println("Elegiria esta herramienta");
        //ImageViewHerramienta imgVHerramienta = (ImageViewHerramienta) event.getSource();
        this.inventario.seleccionarHerramientaAUtilizar(this.herramienta);
    }
}
