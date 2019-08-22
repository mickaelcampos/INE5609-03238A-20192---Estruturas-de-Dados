/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaencadeada;

/**
 *
 * @author 02714395058
 */
public class Caixinha {
    
    Caixinha proximo = null;
    int valor;
    
    public Caixinha(int valor) {
        this.valor = valor;
    }
    
    public Caixinha getProximo() {
        return this.proximo;
    }
    
    public void setProximo(Caixinha proximo) {
        this.proximo = proximo;
    }
}
