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
public class PilhaEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pilha pilha = new Pilha();
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        
        pilha.push(70);
        pilha.push(20);
        
        int teste = pilha.pop();
        teste = pilha.pop();
        teste = pilha.pop();
        teste = pilha.pop();
        teste = pilha.pop();
        System.out.println(teste);
        teste = pilha.pop();
        teste = pilha.pop();
        pilha.push(2600);
        teste = pilha.pop();
        teste = pilha.pop();
        System.out.println(teste);
    }
    
}
