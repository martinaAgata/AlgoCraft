package main;

public abstract class Herramienta {
    public void usar() {

        desgastarse();
    }

    private desgastarse() {
        this.desgaste -= this.calcularDesgaste();
    }

    protected abstract int calcularDesgaste();

}