
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Game
{
    private Level level;
    private List<Event> events = new ArrayList<Event>();
    private List<Character> characters = new ArrayList<Character>();
    
    private void readEvents( String filename ) throws IOException
    {        
         Path path = Paths.get(filename);
         Scanner scanner =  new Scanner(path,"ascii"); 
         while (scanner.hasNextLine()){
             //process each line in some way
             String line = scanner.nextLine();
             System.out.println( "[" + line + "]" );
             String[] columns = line.split( "," );
             double tm = Double.parseDouble( columns[0] );
             String command = columns[1];
             if ( command.equals("print") ) {
                 String message = columns[2];
                 events.add( new PrintEvent(tm,message) );
             }
             else if ( command.equals( "level" ) ) {
                 String name = columns[2];
             }
             else {
                 events.add( new Event(tm) );
             }
         }    
         System.out.println( "Finished reading events" );
    }

    public void init( String filename )  throws IOException {
        readEvents( filename );
    }
        
    public void update( double tm ) 
    {
        Event ev = events.get(0);
        if ( tm>=ev.time ) {
            ev.fire();
            events.remove( 0 );
            System.out.println( "Removed event now we have " + events.size() + " events" );
        }
    }
    
    public void run()
    {
        double t0 = System.nanoTime();        
        while ( !events.isEmpty() ) {
            double gameTime = (System.nanoTime() - t0)*1E-9;
            update( gameTime );
        }
    }

    public static void main( String[] args )  throws IOException
    {        
        Game game = new Game();
        game.init( "Events.csv" );
        game.run();
    }
}
