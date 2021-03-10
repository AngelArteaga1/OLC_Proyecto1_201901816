/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author Angel Arteaga
 */
public class Errores {
    public String Tipo;
    public String Descripcion;
    public int Linea;
    public int Columna;

    public Errores(String Tipo, String Descripcion, int Linea, int Columna) {
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Linea = Linea;
        this.Columna = Columna;
    }
    
}
