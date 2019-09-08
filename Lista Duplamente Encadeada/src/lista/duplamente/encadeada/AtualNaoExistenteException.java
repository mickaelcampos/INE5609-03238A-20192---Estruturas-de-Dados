/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.duplamente.encadeada;

/**
 *
 * @author m1k4
 */
public class AtualNaoExistenteException extends Exception {
    
    public AtualNaoExistenteException() {
        super("A lista esta vazia");
    }
    
}
