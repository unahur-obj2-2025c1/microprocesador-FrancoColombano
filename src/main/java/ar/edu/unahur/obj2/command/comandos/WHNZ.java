package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class WHNZ extends CompositeCommand{

    protected WHNZ(List<Operable> instrucciones) {
        super(instrucciones);
    }

    @Override
    public void doExecute(Programable micro) {
        while (Boolean.TRUE.equals(this.notZero(micro))) {
            super.doExecute(micro);
        }
    }
}
