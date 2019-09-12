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

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        Integer e = 5;
        
        /*Exceptions*/
        lista.excluirUltimo();
        lista.excluirPrimeiro();
        lista.excluirAtual();
        lista.acessarAtual();
        
        
        lista.inserirNaFrete(a);
        Object recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 1
        
        lista.inserirNaFrete(b);
        recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 2
        
        lista.inserirNoFim(c);
        recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 3
        
        lista.excluirUltimo();
        recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 2, pois o ultimo foi excluido
        
        /*Neste momento recebeValor esta valendo 2*/
        lista.inserirAntesDoAtual(d);
        recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 4
        
        lista.excluirUltimo();
        recebeValor = lista.acessarAtual();
        System.out.println(recebeValor); // printa 4
        
        
    }
}
