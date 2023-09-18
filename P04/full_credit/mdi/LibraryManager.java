
/**
 * @author      Anan Rahman
 * @version     1
 * @license     Gnu General Public License 3.0
 */
package mdi;
import java.util.Scanner;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;


/**
 * Main class that manages the library operation
 */
public class LibraryManager{
    /**
     * the main method where execution begins
     * @param args      Command line argument. Not used in this method.
     */
    public static void main(String[] args){
        
        Library library = new Library("UTA Central Library");
        
        library.addPublication(new Publication("Da Vinci Code", "Dan Brown", 2003));
        library.addPublication(new Publication("The Godfather", "Mario Puzo", 1969));
        library.addPublication(new Publication("All The Light We Cannot See", "Anthony Doerr", 2014));
        library.addPublication(new Video("Interstellar", "Christopher Nolan", 2014, 169));
        library.addPublication(new Video("Oppenheimer", "Christopher Nolan", 2023, 180));
        library.addPublication(new Video("The Godfather Part II", "Francis Ford Coppola", 1974, 202));


        
        System.out.println(library);

        Scanner scanner = new Scanner (System.in);
        System.out.print("Which book to check out? ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Who are you? ");
        String patronName = scanner.nextLine();
        
        try {
            library.checkOut(index, patronName);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index");
        } catch (InvalidRuntimeException e){
            System.out.println(e.getMessage());    
        }
        scanner.close();

        System.out.println(library);

        
    }

}