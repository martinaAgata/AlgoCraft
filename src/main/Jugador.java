

public class Jugador(){
    //Atributos
    private ArrayList<Usable> inventario;

    //Constructor
    private Jugador(){
        this.inventario = new ArrayList<Usable>();
    }

    public static Jugador nuevoJugadorConHachaMadera(){
        Jugador jugadorConHachaMadera = new Jugador();
        jugadorConHachaMadera.agregarAInventario((Hacha nuevaHachaMaddera()));
    }

    private void agregarAInventario(Usable usable){
            this.inventario.add(usable);
        }
    public Herramienta getHerramientaActual(){
        //Completar funcion QUITAR
        return null;
        }
}