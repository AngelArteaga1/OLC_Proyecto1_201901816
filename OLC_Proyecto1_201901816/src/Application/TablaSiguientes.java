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
public class TablaSiguientes {
    
    public int id;
    public String valor;
    public List<Integer> siguientes;

    public TablaSiguientes(int id, List siguientes, String valor) {
        this.id = id;
        this.siguientes = siguientes;
        this.valor = valor;
        this.siguientes = new ArrayList<Integer>();
    }

    public int getId() {
        return id;
    }

    public List<Integer> getSiguientes() {
        return siguientes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSiguientes(List<Integer> siguientes) {
        this.siguientes = siguientes;
    }
    
    
    
}
