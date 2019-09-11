/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.duplamente.encadeada;

/**
 *
 * @author 02714395058
 */
public class testListaDuplamenteEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PosicaoNaoExistenteException {
        // TODO code application logic here
//        NodoDuplo nodo = new NodoDuplo(null, null, null);
//        
//        NodoDuplo temp = nodo;
//        
//        NodoDuplo outrotemp = temp;
//        
//        System.out.println(nodo);//@4aa298b7
//        System.out.println(temp);//@4aa298b7
//        System.out.println(outrotemp);//@4aa298b7
//        
//        temp = null;
//        
//        System.out.println("depois");
//        System.out.println(temp);//null
//        System.out.println(outrotemp);//@4aa298b7
//        nodo = null;
//        System.out.println(nodo);
//        System.out.println(outrotemp);//null?
        
        
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        
        
        //lista.inserirNaFrete(lista);
        lista.excluirAtual();
        lista.excluirPrimeiro();
        
       
    }
    
}
