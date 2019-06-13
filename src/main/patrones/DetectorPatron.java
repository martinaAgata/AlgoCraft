package main.patrones;

import main.herramientas.Herramienta;

import main.ConstructorDeHerramientas;
import main.mapa.Mapa;

import java.util.Optional;

public abstract class DetectorPatron {

        private ConstructorDeHerramientas constructor;
        private Optional<DetectorPatron> siguiente = Optional.empty();

        public DetectorPatron(ConstructorDeHerramientas constructor) {
            this.constructor = constructor;
        }

        public DetectorPatron(DetectorPatron siguiente) {
            this.siguiente = Optional.of(siguiente);
        }

        public Optional<Herramienta> resolver(Mapa tablero) {
            if (puedoResolver(tablero)) {
                return Optional.of(constructor.construir());
            } else if (siguiente.isPresent()) {
                return siguiente.get().resolver(tablero);
            } else {
                return Optional.empty();
            }
        }

        private boolean puedoResolver(Mapa mapa) {
            return mapa.equals(this.getMapaPatron());
        }

        protected abstract Mapa getMapaPatron();

    }
    }