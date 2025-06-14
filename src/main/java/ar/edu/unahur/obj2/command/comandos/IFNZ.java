package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class IFNZ extends CompositeCommand{

    protected IFNZ(List<Operable> instrucciones) {
        super(instrucciones);
    }

    @Override
    public void doExecute(Programable micro) {
        if (this.notZero(micro)) {
            super.doExecute(micro);
        }
    }
}
