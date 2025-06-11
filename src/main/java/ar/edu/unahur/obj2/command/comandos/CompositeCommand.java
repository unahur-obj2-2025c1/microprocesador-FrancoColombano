package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public abstract class CompositeCommand extends Command{
    
    protected List<Operable> instrucciones;

    protected CompositeCommand(List<Operable> instrucciones) {
        this.instrucciones = new ArrayList<>(instrucciones);
    }

    protected Boolean notZero(Programable micro) {
        return !micro.getAcumuladorA().equals(0);
    }

    @Override
    public void doExecute(Programable micro) {
        if (Boolean.TRUE.equals(this.notZero(micro))) {
            micro.run(instrucciones);
        }
    }
}