/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.duplamente.encadeada;

/**
 *
 * @author 02714395058
 *
 */
public class ListaDuplamenteEncadeadaCursorEntreElementos {

    private NodoDuplo inicio, fim, cursor;
    private int numElementos;
    
    public ListaDuplamenteEncadeadaCursorEntreElementos() {
        this.inicio = null;
        this.fim = null;
        this.cursor = new NodoDuplo(null, null, null);
        this.numElementos = 0;
        
    }
    
    private NodoDuplo getCursor() {
        return this.cursor;
    }
    
    private void setCursor(NodoDuplo nodoDuplo) {
        this.cursor = nodoDuplo;
    }

    public NodoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NodoDuplo inicio) {
        this.inicio = inicio;
    }

    public NodoDuplo getFim() {
        return fim;
    }

    public void setFim(NodoDuplo fim) {
        this.fim = fim;
    }
    
    // metodos privados do cursor
    
    private void avancarKPosicoes(int k) throws ProximoNaoExistenteException, AnteriorNaoExistenteException {
        for (int i = 0; i < k-1; i++) {
            this.cursor.setAnterior(this.cursor.getProximo());
            this.cursor.setProximo(this.cursor.getAnterior().getProximo());
        }
    }
    
    private void retrocedorKPosicoes(int k) throws AnteriorNaoExistenteException, ProximoNaoExistenteException {
        for (int i = 0; i < k-1; i++) {
            this.cursor.setProximo(this.cursor.getAnterior());
            this.cursor.setAnterior(this.cursor.getProximo().getAnterior());
        }
    }
    
    private void irParaPrimeiro() {
        this.cursor.setAnterior(null);
        this.cursor.setProximo(inicio);
    }
    
    private void irParaUltimo() {
        this.cursor.setProximo(null);
        this.cursor.setAnterior(fim);
    }
    
    
    
    //metodos publicos da classe
    
    public void inserirNoFim(Object elemento) {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (numElementos == 0) {
            this.setFim(novo);
            this.setInicio(novo);
            this.getCursor().setAnterior(novo);
            numElementos++;
        } else {
            this.getFim().setProximo(novo);
            this.setFim(novo);
            this.getCursor().setAnterior(novo);
            numElementos++;
        }        
    }
    
    public void inserirNaFrente(Object elemento) throws ProximoNaoExistenteException, AnteriorNaoExistenteException {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        this.irParaPrimeiro();
        novo.setProximo(inicio);
        inicio.setAnterior(novo);
        this.setInicio(novo);
        numElementos++;
        avancarKPosicoes(1);
    }
}