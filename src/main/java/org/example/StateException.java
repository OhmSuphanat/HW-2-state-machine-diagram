/**6510450976
 *Suphanat Sroyphet
 */
package org.example;

public class StateException extends RuntimeException{
    public StateException() {
        super("Current state's not be able to use this Method.");
    }
}
