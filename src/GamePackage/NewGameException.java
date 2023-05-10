package GamePackage;

/**
 * This is an exception to be thrown when a new game should be created
 */
public class NewGameException extends Exception{
    /**
     * This constructor is used to throw the exception
     */
    public NewGameException() {super("The new game is going to be created");}
}
