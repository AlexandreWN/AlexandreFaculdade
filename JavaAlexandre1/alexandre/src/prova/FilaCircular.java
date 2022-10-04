package prova;
import java.awt.Fila;

public class FilaCircular<T> implements Fila<T> {
    private int base = 0;
    private int topo = -1;
    private T[] dados;
    public FilaCircular(int tamanho) {
    this.dados = (T[]) new Object[tamanho];
    }
    private int mover(int posicao) {
    return posicao+1 == dados.length ? 0 : posicao+1;
}

