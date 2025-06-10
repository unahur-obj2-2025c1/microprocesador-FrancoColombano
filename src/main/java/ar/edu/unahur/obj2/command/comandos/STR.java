package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR implements Operable{
    private Integer addr;
    private Programable copia;
    public STR (Integer addr){
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        micro.setAddr(addr);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
