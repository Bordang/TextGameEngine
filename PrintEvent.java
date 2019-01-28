
/**
 * Write a description of class PrintEvent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrintEvent extends Event
{
    private String message;
    
    /**
     * Constructor for objects of class PrintEvent
     */
    public PrintEvent( double tm, String str )
    {
        super(tm);
        message = str;
    }
    
    public void fire() {
        System.out.println( message );
    }
}
