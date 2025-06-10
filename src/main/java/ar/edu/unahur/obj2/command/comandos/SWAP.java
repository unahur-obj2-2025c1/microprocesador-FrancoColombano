package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable{
    private Programable copia;

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        Integer a = micro.getAcumuladorA();
        Integer b = micro.getAcumuladorB();
        micro.setAcumuladorA(b);
        micro.setAcumuladorB(a);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
