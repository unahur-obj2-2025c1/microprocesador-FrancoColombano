package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class NOP implements Operable{
    private Programable copia;

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
