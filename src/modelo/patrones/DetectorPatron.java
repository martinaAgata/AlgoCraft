package modelo.patrones;

import modelo.herramientas.ConstructorHerramienta;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import java.util.Optional;

public abstract class DetectorPatron {

        private ConstructorHerramienta constructor;
        private Optional<DetectorPatron> siguiente = Optional.empty();
        protected Patron patron;


        public DetectorPatron(ConstructorHerramienta constructor) {
            this.constructor = constructor;
        }

        public DetectorPatron(ConstructorHerramienta constructor, DetectorPatron siguiente) {
            this(constructor);
            this.siguiente = Optional.of(siguiente);
        }

        public Optional<Herramienta> resolverPatron(Mapa tablero) {
            if (this.patron.getMapa().esIgualA(tablero)) { return Optional.of(constructor.construir()); }
            else if (siguiente.isPresent()) { return siguiente.get().resolverPatron(tablero); }
            else { return Optional.empty(); }
        }

        public void agregarSiguiente(DetectorPatron dp){ this.siguiente = Optional.of(dp); }
}
