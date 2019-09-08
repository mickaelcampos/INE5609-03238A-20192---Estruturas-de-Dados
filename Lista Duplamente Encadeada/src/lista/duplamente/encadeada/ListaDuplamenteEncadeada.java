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
public class ListaDuplamenteEncadeada {

    private NodoDuplo inicio, fim, cursor;
    private int numElementos;
    
    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.cursor = null;
        this.numElementos = 0;
    }
    
    private void inserirEmListaVazia(Object elemento) {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        this.inicio = novo;
        this.fim = novo;
        this.cursor = novo;
        this.numElementos++;
    }
    
    private void avancarKPosicoes(int k) throws ProximoNaoExistenteException {
        for (int i = 0; i < k-1; i++) {
            this.cursor = this.cursor.getProximo();
        }
    }
    
    private void retrocederKPosicoes(int k) throws AnteriorNaoExistenteException {
        for (int i = 0; i < k-1; i++) {
            this.cursor = this.cursor.getAnterior();
        }
    }
    
    private void irParaPrimeiro() {
        this.cursor = inicio;
    }
    
    private void irParaUltimo() {
        this.cursor = fim;
    }
    
    public void inserirNoFim(Object elemento) throws ProximoNaoExistenteException {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (numElementos == 0) {
            this.inicio = novo;
            this.fim = novo;
            this.cursor = novo;
            this.numElementos++;
        } else {
            this.fim = novo;
            this.cursor.setProximo(novo);
            novo.setAnterior(this.cursor);
            this.avancarKPosicoes(1);
            this.numElementos++;
        }
    }
    
    public void inserirNaFrete(Object elemento) throws AnteriorNaoExistenteException {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
            this.inicio = novo;
            this.fim = novo;
            this.cursor = novo;
            this.numElementos++;
        } else {
            this.irParaPrimeiro();
            this.cursor.setAnterior(novo);
            novo.setProximo(this.cursor);
            this.inicio = novo;
            this.retrocederKPosicoes(1);
            this.numElementos++;
        }
    }
    
    public void inserirAntesDoAtual(Object elemento) throws AnteriorNaoExistenteException {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
            inserirEmListaVazia(elemento);
        } else if (this.cursor == inicio) {
            inserirNaFrete(elemento);
        } else {
            novo.setProximo(this.cursor);
            novo.setAnterior(this.cursor.getAnterior());
            this.cursor.getAnterior().setProximo(novo);
            this.cursor.setAnterior(novo);
            retrocederKPosicoes(1);
            this.numElementos++;
        }
    }
    
    public void inserirAposAtual(Object elemento) throws ProximoNaoExistenteException {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
            inserirEmListaVazia(elemento);
        } if (this.cursor == fim) {
            inserirNoFim(elemento);
        } else {
            novo.setAnterior(this.cursor);
            novo.setProximo(this.cursor.getProximo());
            this.cursor.getProximo().setAnterior(novo);
            this.cursor.setProximo(novo);
            avancarKPosicoes(1);
            this.numElementos++;
        }
    }
    
    public void inserirNaPosicao(Object elemento, int pos) throws ProximoNaoExistenteException, 
            PosicaoNaoExistenteException, AnteriorNaoExistenteException {
        try { 
            if (pos > this.numElementos) {
                throw new PosicaoNaoExistenteException();
            } 
        } catch(PosicaoNaoExistenteException e) {
            e.getMessage();
        }
        
        if(pos == numElementos) {
            this.irParaUltimo();
        } else {
            this.irParaPrimeiro();
            avancarKPosicoes(pos);
        }
        
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        
        if (numElementos == 0) {
            inserirEmListaVazia(elemento);
        } else if (numElementos == 1) {
            
                novo.setProximo(this.cursor.getProximo());
                novo.setAnterior(this.cursor.getAnterior());
                this.inicio = novo;
                this.fim = novo;
                this.cursor = novo;

        } else {
            
            novo.setAnterior(this.cursor.getAnterior());
            this.cursor.getAnterior().setProximo(novo);
            novo.setProximo(this.cursor.getProximo());
            this.cursor.getProximo().setAnterior(novo);
            this.cursor = novo;
            this.numElementos++;
        }
    }
    
    public void excluirAtual() throws ProximoNaoExistenteException, AnteriorNaoExistenteException {
        try {
            if (this.cursor == null) {
                throw new AtualNaoExistenteException();
            }
        } catch(AtualNaoExistenteException e) {
            e.getMessage();
        }
        
        if (numElementos == 1) {
            this.cursor = null;
            this.inicio = null;
            this.fim = null;
            numElementos--;
        }
        
        if (this.cursor == inicio && numElementos > 1) {
            this.inicio = this.cursor.getProximo(); //
            avancarKPosicoes(1);
            this.cursor.setAnterior(null);
        }
        
        if (this.cursor == fim && numElementos > 1) {
            this.fim = this.cursor.getAnterior();
            retrocederKPosicoes(1);
            this.cursor.setProximo(null);
        }
        
        if (this.cursor != inicio && this.cursor != fim) {
            this.cursor.getAnterior().setProximo(this.cursor.getProximo());
            this.cursor.getProximo().setAnterior(this.cursor.getAnterior());
            numElementos--;
        }
       
    }
}