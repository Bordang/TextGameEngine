
/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event
{
    // instance variables - replace the example below with your own
    public double time;

    /**
     * Constructor for objects of class Event
     */
    public Event( double tm )
    {
        // initialise instance variables
        time = tm;
    }

    public void fire() {
        System.out.println( "Event fired" );
    }
}
