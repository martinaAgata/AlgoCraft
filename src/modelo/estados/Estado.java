package modelo.estados;

public interface Estado {

    Estado desgastar(int fuerza);

    int getDurabilidad();


}
