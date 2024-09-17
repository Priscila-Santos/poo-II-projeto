package exercicios.resolucao.pilha.matheusgomes;

public interface Stack<E> {
    void push(E element);
    E pop() throws Exception;
    E peek() throws Exception;
    int size();
    boolean isEmpty();
}
