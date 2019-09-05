/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.encadeada;

/**
 *
 * @author m1k4
 */
public class ListaEncadeada {
    
    Nodo inicio, fim;
    int numElementos;
    
    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.numElementos = 0;
    }
    
    public void insereNaFrente(Object elemento) {
        
        Nodo novo = new Nodo(this.inicio, elemento);
        this.inicio = novo;
        
        if (numElementos == 0) {
            this.fim = inicio;
        }
        numElementos++;
    }
    
    public void insereNoFim(Object elemento) {
        
        Nodo novo = new Nodo(null, elemento);
        
        if(numElementos == 0) {
            this.inicio = novo;
        }
        
        this.fim = novo;
        numElementos++;
    }
    
    
}
