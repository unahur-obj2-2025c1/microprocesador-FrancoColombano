package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP extends Command{

    @Override
    public void doExecute(Programable micro) {
        Integer a = micro.getAcumuladorA();
        Integer b = micro.getAcumuladorB();
        micro.setAcumuladorA(b);
        micro.setAcumuladorB(a);
    }
}
