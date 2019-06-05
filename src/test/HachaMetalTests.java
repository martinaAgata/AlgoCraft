package test;

import main.estrategias.DesgasteLinealMitad;
import main.estrategias.EstrategiaDesgaste;
import main.herramientas.HachaMetal;
import main.materiales.Madera;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaMetalTests {

    @Test
    public void test12HachaMetalSeUsaContraMaderaReduceSuDurabilidad(){
        EstrategiaDesgaste estrategia = new DesgasteLinealMitad();
        HachaMetal hachaMetal = new HachaMetal(400, 10, estrategia);
        Madera madera = new Madera;
        hachaMetal.usar(madera);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material piedra = Material
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(piedra);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }

    @Test
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(metal);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }

    @Test
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad(){
        HachaMetal hachaMetal = HachaMetal nuevaHachaMetal();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaMetal = hachaMetal.getDurabilidad();
        hachaMetal.usar(diamante);
        assertEquals(durabilidadHachaMetal - 10, hachaMetal.getDurabilidad());
    }


}
