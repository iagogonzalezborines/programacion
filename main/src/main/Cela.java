/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Iago
 */
public class Cela {
    private boolean minada;
    private int estado;
    private int fila;
    private int columna;
    
    public static final int TAPADA = 1;
    public static final int MARCADA = 2;
    public static final int DESTAPADA = 3;
    
    public Cela(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.estado = TAPADA;
        this.minada = false;
    }
    
    public boolean isMinada() {
        return minada;
    }
    
    public void setMinada(boolean minada) {
        this.minada = minada;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getFila() {
        return fila;
    }
    
    public int getColumna() {
        return columna;
    }
}

