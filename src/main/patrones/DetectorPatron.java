package main.patrones;

import main.herramientas.Herramienta;
import main.mapa.Mapa;
import main.materiales.Material;

import java.lang.reflect.Constructor;
import java.util.Optional;

public abstract class DetectorPatron {

        private Constructor constructor;
        private Optional<DetectorPatron> siguiente = Optional.empty();
        protected Patron patron;


        public DetectorPatron(Constructor constructor) {
            this.constructor = constructor;
        }

        public DetectorPatron(Constructor constructor, DetectorPatron siguiente) {
            this(constructor);
            this.siguiente = Optional.of(siguiente);
        }

        public Optional<Herramienta> resolver(Mapa tablero) {
            if (this.patron.getMapa().esIgualA(tablero)) {
                return Optional.of(constructor.construir());
            } else if (siguiente.isPresent()) {
                return siguiente.get().resolver(tablero);
            } else {
                return Optional.empty();
            }
        }
}
