package main.estados;

public interface Estado {

    Estado desgastar(int fuerza);

    int getDurabilidad();


}
