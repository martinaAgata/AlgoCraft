

public class Jugador(){
    //Atributos
    private ArrayList<Usable> inventario;
    private Herramienta herramientaActual;

    //Constructor
    private Jugador(){
        this.inventario = new ArrayList<Usable>();
    }

    public static Jugador nuevoJugadorConHachaMadera(){
        Jugador jugadorConHachaMadera = new Jugador();
        Hacha hachaMadera = Hacha nuevaHachaMaddera();
        jugadorConHachaMadera.agregarAInventario(hachaMadera);
        jugadorConHachaMadera.herramientaActual = hachaMadera;
        return jugadorConHachaMadera;
    }

    public void desgastarMaterial(Material material){
            this.herramientaActual.usar(material);
        }

    private void agregarAInventario(Usable usable){
            this.inventario.add(usable);
        }
    private void getHerramientaActual(){
        //Completar funcion QUITAR
        //No hay ninguna especificacion de como se utilizara/elegira una Herramienta. QUITAR
        return (this.inventario[0]);
        }
}