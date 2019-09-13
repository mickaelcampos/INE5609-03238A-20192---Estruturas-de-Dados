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
    
    private void avancarKPosicoes(int k) {
        for (int i = 1; k >= i; i++) {
            this.cursor = this.cursor.getProximo();
        }
    }
    
    private void retrocederKPosicoes(int k) {
        for (int i = 1; k >= i; i++) {
            this.cursor = this.cursor.getAnterior();
        }
    }
    
    private void irParaPrimeiro() { 
        this.cursor = inicio;
    }
    
    private void irParaUltimo() { 
        this.cursor = fim;
    }
    
    public void inserirNoFim(Object elemento) throws PosicaoNaoExistenteException {
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
    
    public void inserirNaFrete(Object elemento) {
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
    
    public void inserirAntesDoAtual(Object elemento) throws PosicaoNaoExistenteException {
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
    
    public void inserirAposAtual(Object elemento) throws PosicaoNaoExistenteException {
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
    
    public void inserirNaPosicao(Object elemento, int pos) throws PosicaoNaoExistenteException {
        try { 
            if (pos > this.numElementos) {
                throw new PosicaoNaoExistenteException();
            } else {
                
                if(pos == numElementos) {
                    this.irParaUltimo();
                } else if (pos <= numElementos) {
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

                    if (this.cursor.getProximo() != null) {
                        this.cursor.getProximo().setAnterior(novo);
                    }

                    this.cursor = novo;
                    this.numElementos++;
                }
            }
        } catch(PosicaoNaoExistenteException e) {
            e.getMessage();
        }
    }
    
    public void excluirAtual() throws PosicaoNaoExistenteException {
        try {
            if (this.cursor == null) {
                throw new PosicaoNaoExistenteException();
            }
        } catch(PosicaoNaoExistenteException e) {
            e.getMessage();
        }
        
        if (numElementos == 1) {
            this.cursor = null;
            this.inicio = null;
            this.fim = null;
            numElementos--;
        }

        if (this.cursor == inicio && numElementos > 1) {
            this.inicio = this.cursor.getProximo();
            this.cursor.setProximo(null);
            this.cursor = inicio;
            this.cursor.setAnterior(null);
            numElementos--;
        }

        if (this.cursor == fim && numElementos == 1) {
            this.fim = this.cursor.getAnterior();
            this.cursor.setAnterior(null);
            this.cursor = fim;
            this.inicio = this.cursor;
            numElementos--;
        }

        if (this.cursor == fim && numElementos > 1) {
            this.fim = this.cursor.getAnterior();
            this.cursor.setAnterior(null);
            this.cursor = fim;
            this.cursor.setProximo(null);
            numElementos--;
        }

        if (this.cursor != inicio && this.cursor != fim && numElementos > 2) {
            this.cursor.getProximo().setAnterior(this.cursor.getAnterior());
            NodoDuplo temp = this.cursor.getAnterior();
            this.cursor.setProximo(null);
            this.cursor.setAnterior(null);
            this.cursor = temp;
            temp = null;
            numElementos--;
        }
    }
    
    public void excluirPrimeiro() throws PosicaoNaoExistenteException {        
        
        if (numElementos == 1) {
            this.cursor = null;
            this.inicio = null;
            this.fim = null;
            numElementos--;
        }
        
        if (numElementos > 1) {
            System.out.println(numElementos);
            System.out.println(this.inicio+"inicio");
            System.out.println(this.fim+"fim");
            System.out.println(this.cursor+"cursor");
            irParaPrimeiro();
            this.inicio = this.cursor.getProximo();
            this.cursor.setProximo(null);
            this.cursor = inicio;
            this.cursor.setAnterior(null);
            numElementos--;
        }
    }
    
    public void excluirUltimo() {
        irParaUltimo();
        
        if (numElementos == 1) {
            this.cursor = null;
            this.inicio = null;
            this.fim = null;
            numElementos--;
        }
        
        if (numElementos > 1) {
            this.fim = this.cursor.getAnterior();
            this.cursor.setAnterior(null);
            this.cursor = fim;
            this.cursor.setProximo(null);
            numElementos--;
        }
    }
    
    public boolean buscar(Object elemento) {
        boolean achou = false;
        if (elemento != null) {
            
            NodoDuplo atual = this.cursor;
            irParaPrimeiro();
            
            if (this.cursor != null) {
                while (!achou) {
                    if(this.cursor.getElemento().equals(elemento)) {
                        achou = true;
                    }
                    
                avancarKPosicoes(1);
                }
            this.cursor = atual;
            
            }
            
        }
        
        return achou;
    }
    
    /** Método para acessar o elemento apontado pelo cursor.
    * O cursor aponta para o ultimo elemento inserido na lista,
    * caso o elemento apontado seja excluido, o cursor apontará para
    * o elemento anterior.
    * @return Object - elemento armazenado dentro da lista
    */
    
    public Object acessarAtual()  {
        try {
            if (this.cursor != null) {
                return this.cursor.getElemento();
            } else {
                throw new PosicaoNaoExistenteException();
            }
        } catch (PosicaoNaoExistenteException e) {
            e.getMessage();
        }
        return null;
    }
    
}