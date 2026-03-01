package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue { 
    /**
     * Aggiunge un elemento alla coda.
     * Se la coda è piena, sovrascrive l'elemento più vecchio.
     */
    void enqueue(int value);
    
    /**
     * Rimuove e ritorna l'elemento più vecchio della coda.
     * Se la coda è vuota, lancia un'eccezione.
     */
    int dequeue();
    
    /**
     * Ritorna l'elemento più vecchio senza rimuoverlo.
     * Se la coda è vuota, lancia un'eccezione.
     */
    int peek();
    
    /**
     * Controlla se la coda è vuota.
     */
    boolean isEmpty();
    
    /**
     * Controlla se la coda è piena.
     */
    boolean isFull();
    
    /**
     * Ritorna il numero di elementi attuali nella coda.
     */
    int size();
    
    /**
     * Ritorna la capacità massima della coda.
     */
    int capacity();

}