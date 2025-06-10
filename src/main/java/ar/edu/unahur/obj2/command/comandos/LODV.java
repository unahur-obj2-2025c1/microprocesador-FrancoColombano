package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV implements Operable {
    Integer valor;
    private Programable copia;

    public LODV(Integer valor){
        this.valor = valor;
    }

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        micro.setAcumuladorA(valor);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
