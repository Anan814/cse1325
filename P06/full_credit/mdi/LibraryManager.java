/**
 * @author      Anan Rahman
 * @version     1
 * @license     Gnu General Public License 3.0
 */
package mdi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import library.Publication;
import library.Publication.InvalidCheckInException;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;
import java.io.FileWriter;
//import java.io.IOException;
import java.io.IOException;


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
        
        Scanner scanner = new Scanner (System.in);

        /*static void saveLibrary(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.println("Enter filename to save: ");
            String fileName = scanner.nextLine();
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
                library.save(bw);
            } catch (IOException e){
                System.err.println("Failed to save: " + e); System.exit(-1);
            }

               
            }

        static Library openLibrary(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.println("Enter filename to open: ");
            String fileName = scanner.nextLine();

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                library = new Library(br);
                return library;
            } catch (IOException e){
                System.err.println("Failed to open: " + e); System.exit(-1);
            }
            return null;

        }*/
        

        
        while( true){
             
            menu();
            System.out.println("\n\n");
            System.out.print("Selection: ");
            int choice =  scanner.nextInt();
            switch(choice) {
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    list(library);
                    break;
                case 2:
                    addPublication(library, scanner);
                    break;
                case 3:
                    addVideo(library, scanner);
                    break;
                case 4:
                    checkingOut(library, scanner);
                    break;
                case 5:
                    checkingIn(library, scanner);
                    break;
                case 6:
                    library = openLibrary( library, scanner);
                    break;
                case 7:
                    saveLibrary(library, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
            
        }
        
    }

        static void menu(){
            System.out.println("=========\nMain Menu\n=========");
            System.out.println("UTA Central Library");
            System.out.println("0)Exit\n1)List\n2)Add Publication\n3)Add Video\n4)Check out\n5)Check in\n6)Open\n7)Save");
        }

        static void list(Library library){
            System.out.println(library);
        }

        static void addPublication(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.print("Enter the title of the Publication: ");
            String title = scanner.nextLine();
            System.out.print("Enter the author of the Publication: ");
            String author = scanner.nextLine();
            System.out.print("Enter the copyright year of the Publication: ");
            int copyright = scanner.nextInt();
            scanner.nextLine();

            Publication publication = new Publication(title, author, copyright);
            library.addPublication(publication);
            System.out.println("Publication added successfully!");
        }

        static void addVideo(Library library, Scanner scanner) {
            scanner.nextLine();
            System.out.print("Enter the title of the Video: ");
            String title = scanner.nextLine();
            
            System.out.print("Enter the director of the Video: ");
            String director = scanner.nextLine();
            System.out.print("Enter the copyright year of the Video: ");
            int copyright = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter the runtime of the Video (in minutes): ");
            int runtime = scanner.nextInt();
            scanner.nextLine(); 
    
            try {
                Video video = new Video(title, director, copyright, runtime);
                library.addPublication(video);
                System.out.println("Video added successfully!");
            } catch (Video.InvalidRuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        static void checkingOut(Library library, Scanner scanner){
            
            scanner.nextLine();
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
            
        }

        static void checkingIn(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.print("Which book to check in? ");
            int index = scanner.nextInt();
            scanner.nextLine();
            

            
            
            try {
                
                library.checkIn(index);
            
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid publication index");
                } catch (InvalidRuntimeException e){
                System.out.println(e.getMessage());
                } catch (InvalidCheckInException e){
                System.out.println(e.getMessage());    
            }
            
        }

        static void saveLibrary(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.println("Enter filename to save: ");
            String fileName = scanner.nextLine();
            
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
                library.save(bw);
            } catch (IOException e){
                System.err.println("Failed to save: " + e); System.exit(-1);
            }

               
            }

        static Library openLibrary( Library library, Scanner scanner){
            scanner.nextLine();
            System.out.println("Enter filename to open: ");
            String fileName = scanner.nextLine();
            

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                library = new Library(br);
                return library;
            } catch (IOException e){
                System.err.println("Failed to open: " + e); System.exit(-1);
            }
            return null;

        }



        
        
        
    
}