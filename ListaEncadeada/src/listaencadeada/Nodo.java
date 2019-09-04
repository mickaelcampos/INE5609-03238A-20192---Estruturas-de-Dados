/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencadeada;

/**
 *
 * @author m1k4
 */
public class Nodo {
    
    Nodo proximo;
    Object elemento;
    
    public Nodo(Nodo proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }
}
