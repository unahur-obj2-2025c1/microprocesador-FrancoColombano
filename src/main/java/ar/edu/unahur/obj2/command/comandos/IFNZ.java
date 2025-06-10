package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class IFNZ implements Operable{
    private List<Operable> instrucciones;
    private Programable copia;

    public IFNZ(List<Operable> instrucciones){
        this.instrucciones = instrucciones;
    }
    @Override
    public void execute(Programable micro) {
        this.copia = micro.copy();
        if (micro.getAcumuladorA()!=0) {
            micro.run(instrucciones);
            micro.incProgramCounter();
        }
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(copia);
    }
}
