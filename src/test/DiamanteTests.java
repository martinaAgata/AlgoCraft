package test;

import org.junit.Test;

public class DiamanteTests {
    @Test
    public void test01CrearDiamante() {
        Material diamante = Material nuevoDiamante();
        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test01DiamanteNoEsDesgastadoPorHachaMadera(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Hacha hachaMadera = Hacha nuevaHachaMadera();
        diamante.usar(hachaMadera);
        assertEquals(durabilidadDiamante, diamante.getdurabilidad());
    }

    @Test
    public void test02DiamanteNoEsDesgastadoPorHachaPiedra(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Hacha hachaPiedra = Hacha nuevaHachaPiedra();
        diamante.usar(hachaPiedra);
        assertEquals(durabilidadDiamante, diamante.getdurabilidad());
    }

    @Test
    public void test03DiamanteNoEsDesgastadoPorHachaMetal(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Hacha hachaMetal = Hacha nuevaHachaMetal();
        diamante.usar(hachaMetal);
        assertEquals(durabilidadDiamante, diamante.getdurabilidad());
    }

    @Test
    public void test04DiamanteNoEsDesgastadoPorPicoMadera(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Pico picoMadera = Pico nuevoPicoMadera();
        diamante.usar(picoMadera);
        assertEquals(durabilidadDiamante, diamante.getdurabilidad());

    }

    @Test
    public void test05DiamanteNoEsDesgastadoPorPicoPiedra(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Pico picoPiedra = Pico nuevoPicoPiedra();
        diamante.usar(picoPiedra);
        assertEquals(diamantelidadDiamante, madera.getdurabilidad());
    }

    @Test
    public void test06DiamanteNoEsDesgastadoPorPicoMetal(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        Pico picoMetal = Pico nuevoPicoMetal();
        diamante.usar(picoMetal);
        assertEquals(diamantelidadDiamante, madera.getdurabilidad());
    }

    @Test
    public void test07DiamanteEsDesgastadoPorPicoFino(){
        Material diamante = Material nuevoDiamante();
        Integer durabilidadDiamante = diamante.getdurabilidad();
        PicoFino picoFino = PicoFino nuevoPicoFino();
        diamante.usar(hachaMadera);
        assertEquals(durabilidadDiamante -20, diamante.getdurabilidad());
    }
}

