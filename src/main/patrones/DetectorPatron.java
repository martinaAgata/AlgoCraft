package main.patrones;

import main.herramientas.Herramienta;
import main.mapa.Mapa;

import java.util.Optional;

public abstract class DetectorPatron {/*
        private Optional<DetectorPatron> siguiente = Optional.empty();

        public DetectorPatron() {

        }

        public DetectorPatron(DetectorPatron siguiente) {
            this.siguiente = Optional.of(siguiente);
        }

        public Optional<Herramienta> resolver(Mapa mapita) {
            if (puedoResolver(mapita)) {
                return Optional.of(crearHerramienta());
            } else if (siguiente.isPresent()) {
                return siguiente.get().resolver(mapita);
            } else {
                return Optional.empty();
            }
        }

        private boolean puedoResolver(Mapa mapa) {
            // El equals del mapa tiene que fijarse que ambos tengan mismo ancho y alto
            // Luego que casillero a casillero esten ocupados o desocupados de misma forma
            // si estan ocupados, ver que sea con lo mismo (equals -> hay que redefinir el equals
            // en material y que solo chequee que sean del mismo material)
            return mapa.equals(this.getMapaPatron());
        }

        protected abstract Herramienta crearHerramienta();

        protected abstract Mapa getMapaPatron();

    }

*/
}

