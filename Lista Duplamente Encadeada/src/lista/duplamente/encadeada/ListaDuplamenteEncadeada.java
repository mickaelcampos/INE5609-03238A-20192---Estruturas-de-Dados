package lista.duplamente.encadeada;

/**Classe para objetos do tipo ListaDuplamenteEncadeada, onde serao contidos, valores e metodos para o mesmo.
* @author 02714395058
*/

public class ListaDuplamenteEncadeada {

    private NodoDuplo inicio, fim, cursor;
    private int numElementos;
    
    /** Metodo construtor.
    */
    
    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.cursor = null;
        this.numElementos = 0;
    }
    
    /** Metodo que permite inserir um objeto na lista vazia.
     * @param elemento 
     */
    
    private void inserirEmListaVazia(NodoDuplo novo) {
        this.inicio = novo;
        this.fim = novo;
        this.cursor = novo;
        this.numElementos++;
    }
    
    /** Metodo que permite fazer o cursor avancar posicoes,
     * @param k - numero de posicoes que o cursor deve avancar.
     */
    
    private void avancarKPosicoes(int k) {
        for (int i = 1; k >= i; i++) {
            this.cursor = this.cursor.getProximo();
        }
    }
    
    /** Metodo que permite fazer o cursor retroceder posicoes,
     * @param k - numero de posicoes que o cursor deve retroceder.
     */
    
    private void retrocederKPosicoes(int k) {
        for (int i = 1; k >= i; i++) {
            this.cursor = this.cursor.getAnterior();
        }
    }
    
    /** Metodo que permite fazer o cursor apontar para o inicio.
     */
    
    private void irParaPrimeiro() { 
        this.cursor = inicio;
    }
    
    /** Metodo que permite fazer o cursor apontar para o fim.
     */
    
    private void irParaUltimo() { 
        this.cursor = fim;
    }
    
    /** Metodo que permite inserir um objeto no fim da lista.
     * Apos o elemento ser inserido, o cursor passa a apontar para o mesmo.
     * @param elemento - objeto a ser inserido.
     */
    
    public void inserirNoFim(Object elemento) {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (numElementos == 0) {
            this.inserirEmListaVazia(novo);
        } else {
            this.irParaUltimo(); //
            this.fim = novo;
            this.cursor.setProximo(novo);
            novo.setAnterior(this.cursor);
            this.avancarKPosicoes(1);
            this.numElementos++;
        }
    }
    
    /** Metodo que permite inserir um objeto no inicio da lista.
     * Apos o elemento ser inserido, o cursor passa a apontar para o mesmo.
     * @param elemento - objeto a ser inserido.
     */
    
    public void inserirNaFrete(Object elemento) {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
           this.inserirEmListaVazia(novo);
        } else {
            this.irParaPrimeiro();
            this.cursor.setAnterior(novo);
            novo.setProximo(this.cursor);
            this.inicio = novo;
            this.retrocederKPosicoes(1);
            this.numElementos++;
        }
    }
    
    /** Metodo que permite inserir um objeto antes do cursor.
     * Apos o elemento ser inserido, o cursor passa a apontar para o mesmo.
     * @param elemento - objeto a ser inserido.
     */
    
    public void inserirAntesDoAtual(Object elemento) {
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
            inserirEmListaVazia(novo);
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
    
    /** Metodo que permite inserir um objeto apos o cursor.
     * Apos o elemento ser inserido, o cursor passa a apontar para o mesmo.
     * @param elemento - objeto a ser inserido.
     */
    
    public void inserirAposAtual(Object elemento) {
        
        NodoDuplo novo = new NodoDuplo(null, null, elemento);
        if (this.numElementos == 0) {
            inserirEmListaVazia(novo);
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
    
    /** Metodo que permite inserir em determinada posicao.
     * Apos o elemento ser inserido, o cursor passa a apontar para o mesmo.
     * @param elemento - objeto a ser inserido.
     * @param pos - posicao onde o elemento deve ser inserido.
     */
    
    public void inserirNaPosicao(Object elemento, int pos) throws PosicaoNaoExistenteException {
        try { 
            if (pos > this.numElementos) {
                throw new PosicaoNaoExistenteException();
            } else {
                
                if(pos == numElementos) {
                    this.irParaUltimo();
                } else if (pos < numElementos) {
                    this.irParaPrimeiro();
                    avancarKPosicoes(pos);
                }

                NodoDuplo novo = new NodoDuplo(null, null, elemento);

                if (numElementos == 0) {
                    inserirEmListaVazia(novo);
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
    
    /** Metodo que permite excluir o elemento apontado pelo cursor.
     * Apos o elemento ser excluido, o cursor passa a apontar para o anterior.
     * Caso o elemento excluido seja o inicio, o cursor apontará para null.
     * @throws lista.duplamente.encadeada.PosicaoNaoExistenteException - Caso
     * a lista esteja vazia.
     */
    
    public void excluirAtual() throws PosicaoNaoExistenteException {
        try {
            if (this.cursor == null) {
                
                throw new PosicaoNaoExistenteException();
            } else {
                
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

                if (this.cursor == fim && numElementos > 1) {
                    this.fim = this.cursor.getAnterior();
                    this.cursor.setAnterior(null);
                    this.cursor = fim;
                    this.cursor.setProximo(null);
                    numElementos--;
                }

                if (this.cursor != inicio && this.cursor != fim && numElementos > 2) {
                    this.cursor.getProximo().setAnterior(this.cursor.getAnterior());
                    this.cursor.getAnterior().setProximo(this.cursor.getProximo());
                    NodoDuplo temp = this.cursor.getAnterior();
                    this.cursor.setProximo(null);
                    this.cursor.setAnterior(null);
                    this.cursor = temp;
                    temp = null;
                    numElementos--;
                }
            }
        } catch(PosicaoNaoExistenteException e) {
            e.getMessage();
        } 
    }
    
    /** Metodo que permite excluir o primeiro elemento apontado pelo cursor.
     * Apos o elemento ser excluido, o cursor apontará para o inicio.
     * @throws lista.duplamente.encadeada.PosicaoNaoExistenteException - Caso
     * a lista esteja vazia.
     */
    
    public void excluirPrimeiro() throws PosicaoNaoExistenteException {        
        try {
            if (this.cursor == null) {
                throw new PosicaoNaoExistenteException();
            } else {
            
                if (numElementos == 1) {
                    this.cursor = null;
                    this.inicio = null;
                    this.fim = null;
                    numElementos--;
                }

                if (numElementos > 1) {
                    irParaPrimeiro();
                    this.inicio = this.cursor.getProximo();
                    this.cursor.setProximo(null);
                    this.cursor = inicio;
                    this.cursor.setAnterior(null);
                    numElementos--;
                }
            }    
        } catch (PosicaoNaoExistenteException e) {
            e.getMessage();
        }
    }
    
    /** Metodo que permite excluir o ultimo elemento apontado pelo cursor.
     * Apos o elemento ser excluido, o cursor apontará para o anterior.
     * Se a lista estiver com apenas 1 elemento, o cursor apontara para null.
     * @throws lista.duplamente.encadeada.PosicaoNaoExistenteException - Caso
     * a lista esteja vazia.
     */
    
    public void excluirUltimo() {
        try {
            if (this.cursor == null) {
                throw new PosicaoNaoExistenteException();
            } else {
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
        } catch (PosicaoNaoExistenteException e) {
            e.getMessage();
        }        
    }
    
    /** Metodo que permite descobrir se um elemento esta na lista.
     * @param elemento - elemento que deseja encontrar.
     */
    
    public boolean buscar(Object elemento) {
        boolean achou = false;
        if (elemento != null) {
            
            NodoDuplo atual = this.cursor;
            irParaPrimeiro();
            int contador = 0;
            if (this.cursor != null) {
                while (!achou && contador < numElementos) {
                    if(this.cursor.getElemento().equals(elemento)) {
                        achou = true;
                    }
                    contador++;
                    avancarKPosicoes(1);
                }
            this.cursor = atual;
            
            }
            
        }
        
        return achou;
    }
    
    /** Método para retornar o elemento apontado pelo cursor no estado atual.
    * O cursor deve apontar para o ultimo elemento inserido na lista.
    * Caso o elemento apontado seja excluido, o cursor apontará para
    * o elemento anterior. Se o elemento excluido for o primeiro, o cursor
    * apontara para o proximo elemento.
    * @return Object - elemento armazenado dentro da lista
    * @throws lista.duplamente.encadeada.PosicaoNaoExistenteException
    */
    
    public Object acessarAtual() throws PosicaoNaoExistenteException {
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