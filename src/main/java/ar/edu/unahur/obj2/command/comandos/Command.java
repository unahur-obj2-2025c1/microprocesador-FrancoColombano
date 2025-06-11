package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class Command implements Operable{
    Programable copia;

    @Override
    public void execute(Programable micro) {
        copia = micro.copy();
        doExecute(micro);
        micro.incProgramCounter();
    }

    public abstract void doExecute(Programable micro);

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }
}
