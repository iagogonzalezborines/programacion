/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Iago
 */
import java.util.ArrayList;
import java.util.Random;

public class Xogo {
    private Cela[][] celas;
    private int filas;
    private int columnas;

    public Xogo(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        celas = new Cela[filas][columnas];
        encherMinas(minas);
    }

    public Cela getCela(int fila, int columna) {
        return celas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    private ArrayList<Cela> getCelasAdxacentes(Cela cela) {
        ArrayList<Cela> adxacentes = new ArrayList<>();
        int fila = cela.getFila();
        int columna = cela.getColumna();
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < filas && j >= 0 && j < columnas && !(i == fila && j == columna)) {
                    adxacentes.add(celas[i][j]);
                }
            }
        }
        return adxacentes;
    }

    public int getMinasAdxacentes(Cela cela) {
        ArrayList<Cela> adxacentes = getCelasAdxacentes(cela);
        int minas = 0;
        for (Cela adxacente : adxacentes) {
            if (adxacente.isMinada()) {
                minas++;
            }
        }
        return minas;
    }

    public void abrirCela(Cela cela) {
        if ((cela.getEstado() == 3 )) {
            cela.setEstado(3);
            if (cela.isMinada()) {
                abrirTodasMinas();
            } else if (getMinasAdxacentes(cela) == 0) {
                ArrayList<Cela> adxacentes = getCelasAdxacentes(cela);
                for (Cela adxacente : adxacentes) {
                    abrirCela(adxacente);
                }
            }
        }
    }

    public void abrirTodasMinas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celas[i][j].isMinada()) {
                    celas[i][j].setEstado(3);
                }
            }
        }
    }

    public boolean comprobarCelasAbrir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(!celas[i][j].isMinada() && celas[i][j].getEstado() == 3 ){
                    return false;
                }
            }
        }
        return true;
    }
    

    private void encherMinas(int mines) {
        Random rnd = new Random();
        for (int i = 0; i < mines; i++) {
            int fila, columna;
            do {
                fila = rnd.nextInt(filas);
                columna = rnd.nextInt(columnas);
            } while (celas[fila][columna] != null && celas
                    [fila][columna].isMinada()); // Xa hai unha cela con mina nesta posición
                celas[fila][columna] = new Cela(filas, columnas);
}
    }
}


