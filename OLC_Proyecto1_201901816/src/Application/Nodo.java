/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author erick
 */
public class Nodo {
    
    public Nodo hizq;
    public Nodo hder;
    public String valor;
    public int id;
    public int num;
    public String anulable;
    public int[] primeros;
    public int [] ultimos;

    public Nodo(Nodo hizq, Nodo hder, String valor, int id, int num, String anulable, int[] primeros, int[] ultimos) {
        this.hizq = hizq;
        this.hder = hder;
        this.valor = valor;
        this.id = id;
        this.num = num;
        this.anulable = anulable;
        this.primeros = primeros;
        this.ultimos = ultimos;
    }

    public Nodo getHizq() {
        return hizq;
    }

    public void setHizq(Nodo hizq) {
        this.hizq = hizq;
    }

    public Nodo getHder() {
        return hder;
    }

    public void setHder(Nodo hder) {
        this.hder = hder;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void ImprimirArbol(){
        if (hizq == null && hder == null){
            System.out.println(valor + " No tengo hijos");
        } else if (hder == null && hizq != null){
            
        }
    }
    
    public String getCodigoInterno() {
        String etiqueta;
        String value;
        if (valor.equals("\\n") || valor.equals("\\'") || valor.equals("\\\"")){
            value = valor.replace("\\", "\\\\");
        } else {
            value = valor;
        }
        if (hizq == null && hder == null) {
            //PARA OBTENER ARREGLO EN STRING
            String CadenaPrimero = "";
            for (int i = 0; i < primeros.length; i++){
                if (i == primeros.length - 1){
                    CadenaPrimero = CadenaPrimero + primeros[i];
                } else {
                    CadenaPrimero = CadenaPrimero + primeros[i] + ",";
                }
            }
            //PARA OBTENER ARREGLO EN STRING
            String CadenaUltimo = "";
            for (int i = 0; i < ultimos.length; i++){
                if (i == ultimos.length - 1){
                    CadenaUltimo = CadenaUltimo + ultimos[i];
                } else {
                    CadenaUltimo = CadenaUltimo + ultimos[i] + ",";
                }
            }
            etiqueta = "nodo" + id + " [ label =\" { " + anulable + " |{" + CadenaPrimero + "|" + value + "|" + CadenaUltimo + "}| id: " + num + "} \"];\n";
        } else {
            //PARA OBTENER ARREGLO EN STRING
            String CadenaPrimero = "";
            for (int i = 0; i < primeros.length; i++){
                if (i == primeros.length - 1){
                    CadenaPrimero = CadenaPrimero + primeros[i];
                } else {
                    CadenaPrimero = CadenaPrimero + primeros[i] + ",";
                }
            }
            //PARA OBTENER ARREGLO EN STRING
            String CadenaUltimo = "";
            for (int i = 0; i < ultimos.length; i++){
                if (i == ultimos.length - 1){
                    CadenaUltimo = CadenaUltimo + ultimos[i];
                } else {
                    CadenaUltimo = CadenaUltimo + ultimos[i] + ",";
                }
            }
            etiqueta = "nodo" + id + " [ label =\" { " + anulable + " |{" + CadenaPrimero + "|" + value + "|" + CadenaUltimo + "}| id: " + num + "} \"];\n";
        }
        if (hizq != null) {
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hizq.id + "\n";
        }
        if (hder != null) {
            etiqueta = etiqueta + hder.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hder.id + "\n";
        }
        return etiqueta;
    }
    
}
