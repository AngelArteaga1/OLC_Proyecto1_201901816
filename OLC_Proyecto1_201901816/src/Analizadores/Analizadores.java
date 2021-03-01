    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author erick
 */
public class Analizadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        generarCompilador();
        //String h12ol2a;
    }
    private static void generarCompilador() 
    {
        try {
            String ruta = "src/Analizadores/";
            String opcFlex[] = {ruta + "Lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
}
