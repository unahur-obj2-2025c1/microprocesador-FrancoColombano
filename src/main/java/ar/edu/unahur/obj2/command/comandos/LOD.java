package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable {
    private Integer addr;
    private Programable copia;

    public LOD (Integer addr){
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        Integer valor = micro.getAddr(addr);
        micro.setAcumuladorA(valor);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }

}
