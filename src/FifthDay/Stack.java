package FifthDay;

public class Stack {
    private int top; // L'indice dell'elemento più in alto
    private final int MAX; // Dimensione massima array
    private char elem[]; // Array contenente pila
    private static final int MAXDEFAULT = 10; // Dimensione massima array se non viene dato alcun parametro

    public Stack() {
        // Senza parametri, settiamo la pila come dimensione di default a 10
        this(MAXDEFAULT);
    }

    public Stack(int MAX) {
        this.top = 0;
        this.MAX = MAX;
        this.elem = new char[MAX];
    }

    public boolean isFull() {
        return (top == MAX);
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public void clear() {
        top = 0;
    }

    // Aggiungiamo item alla pila
    public boolean push(char x) {

        if (!this.isFull()) {
            elem[top++] = x;
            return true;
        }
        else return false;
    }

    // Togliamo item alla pila. Si può perfino vedere che valore viene tolto
    public char pop() {

        if (!this.isEmpty()) return elem[--top];
        else return '/';
    }

    // Leggiamo ultimo elemento della pila senza toglierlo
    public char topElem() {
        if (!this.isEmpty()) return elem[top - 1];
        else return '/';
    }

    @Override
    public String toString() {
        String s = "Pila = {";
        for (int i = 0; i < top; i++) {
            s+="  "+elem[i];
        }
        return s+"  }";
    }
}
