package interfaz.handlers;

import interfaz.ImageViewHerramienta;
import interfaz.Inventario;
import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.herramientas.Herramienta;

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
        this.inventario.seleccionarHerramientaAUtilizar(this.herramienta);
    }
}
