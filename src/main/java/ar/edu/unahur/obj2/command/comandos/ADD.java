package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable{
    private Programable copia;

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        Integer add = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(add);
        micro.setAcumuladorB(0);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
