package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Microprocesador implements Programable{
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoria = new ArrayList<>(Collections.nCopies(1024, 0));

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(op -> op.execute(this));
    }
    @Override
    public void incProgramCounter() {
        programCounter ++;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void copyFrom(Programable programable) {
        this.acumuladorA = programable.getAcumuladorA();
        this.acumuladorB = programable.getAcumuladorB();
        this.programCounter = programable.getProgramCounter();
        this.memoria = programable.getMemoria();
    }
    @Override
    public Programable copy() {
        return this;
    }
    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        for (int i = 0; i < memoria.size(); i++) {
        memoria.set(i, 0);
    }
    }
    @Override
    public void setAddr(Integer addr) {
        validarDireccion(addr);
        memoria.set(addr, acumuladorA);
        
    }
    private void validarDireccion(Integer addr) {
        if (addr < 0 || addr >= 1024) {
        throw new RuntimeException("Dirección de memoria inválida: " + addr);
        }
    }
    @Override
    public Integer getAddr(Integer addr) {
        validarDireccion(addr);
        return memoria.get(addr);
    }
    @Override
    public List<Integer> getMemoria() {
        return new ArrayList<>(memoria);
    }
    @Override
    public void setMemoria(List<Integer> nueva) {
        this.memoria = nueva;
    }
}