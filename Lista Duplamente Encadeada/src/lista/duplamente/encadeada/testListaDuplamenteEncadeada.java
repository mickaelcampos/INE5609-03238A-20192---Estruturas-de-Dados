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
        
        /*testando Exceptions*/
//        lista.excluirUltimo();
//        lista.excluirPrimeiro();
//        lista.excluirAtual();
//        lista.acessarAtual();
        
        
        lista.inserirNaFrete(a);


        
        System.out.println(lista.acessarAtual()); // printa 1
        
        lista.inserirNaFrete(b);
        System.out.println(lista.acessarAtual()); // printa 2
        
        lista.inserirNoFim(c);
        System.out.println(lista.acessarAtual()); // printa 3
        
        lista.excluirUltimo();
        System.out.println(lista.acessarAtual()); // printa 2, pois o ultimo, 3, foi excluido
        
        lista.inserirAntesDoAtual(d);
        System.out.println(lista.acessarAtual()); // printa 4
        
        lista.excluirUltimo();
        System.out.println(lista.acessarAtual()); // printa 4
        
        lista.inserirAposAtual(e);
        System.out.println(lista.acessarAtual()); // printa 5
        
        lista.inserirNaPosicao(a, 50); // dispara exception
        System.out.println(lista.acessarAtual()); // printa 5, pois o elemento a nao foi inserido, nao ha posicao 50
        
        lista.excluirAtual();
        System.out.println(lista.acessarAtual()); // printa 4
        
        lista.excluirPrimeiro();
        //System.out.println(lista.buscar(a)); // printa false
        /*
        (void) InserirAntesDoAtual testado
        (void) InserirApósAtual testado
        (void) inserirNoFim testado
        (void) inserirNaFrente testado
        (void) inserirNaPosicao testado
        (void) ExcluirAtual testado
        (void) ExcluirPrim
        (void) ExcluirUlt testado
        (boolean) Buscar
        <elemento> acessaAtual
        */
        
        
        
    }
}
