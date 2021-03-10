/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.List;

/**
 *
 * @author Angel Arteaga
 */
public class Transiciones {
    public int[][] transiciones;
    public String nombre;
    public int EstadoFinal;
    public List<String> conjuntos;

    public Transiciones(int[][] transiciones, String nombre, int EstadoFinal, List<String> conjuntos) {
        this.transiciones = transiciones;
        this.nombre = nombre;
        this.EstadoFinal = EstadoFinal;
        this.conjuntos = conjuntos;
    }
        
}
