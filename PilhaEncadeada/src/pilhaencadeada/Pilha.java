package pilhaencadeada;
/**
 *
 * @author 02714395058
 */
public class Pilha {
    
    Caixinha topo = null;
    
    public Pilha() {
    
    }
    
    public void push(int valor) {
        Caixinha caixinha = new Caixinha(valor);
        caixinha.setProximo(topo);
        this.topo = caixinha;
        
        
    }
    
    public int pop() {
        if (topo != null) {
        Caixinha temp = topo;
        this.topo = topo.getProximo();
        return temp.valor;
        } else {
            return -1;
        }
    }
}
