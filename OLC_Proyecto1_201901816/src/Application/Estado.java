/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel Arteaga
 */
public class Estado {
    public int S;
    public List<Integer> combinacion;

    public Estado(int S, List<Integer> combinacion) {
        this.S = S;
        this.combinacion = combinacion;
    }

    public int getS() {
        return S;
    }

    public List<Integer> getCombinacion() {
        return combinacion;
    }

    public void setS(int S) {
        this.S = S;
    }

    public void setCombinacion(List<Integer> combinacion) {
        this.combinacion = combinacion;
    }
    
    
    
}
