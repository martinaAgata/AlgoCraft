package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaMadera;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HachaMaderaTests {

    @Test
    public void test04HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera;
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera;
        Piedra piedra = new Piedra();
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(98));;
    }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera;
        Metal metal = new  Metal();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test07HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaMadera hachaMadera = new HachaMadera();
        Diamante diamante = Diamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }
}

