import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


class Publication{

    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright){
        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Invalid copyright year");

        this.title = title;
        this.author = author;
        this.copyright = copyright;


    }

    public void checkOut(String patron){
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    @Override
    public String toString(){
        String stringInfo = "\"" + title + "\" by the author " + author + ", copyright " + copyright;
        //+ "\n" + "  --> loaned to" + loanedTo + "until " + dueDate;
        if ( loanedTo != null)
            stringInfo += ": loaned to " + loanedTo + " until " + dueDate + " ";
        
        return stringInfo + "\n";    
    }
    
}


class Library{

    private String name;
    private ArrayList<Publication> publications = new ArrayList<>() ;

    public Library(String name){
        this.name = name;
        //this.publication  
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron){
        if(publicationIndex >= 0 && publicationIndex < publications.size())
            publications.get(publicationIndex).checkOut(patron);
        else
            throw new IndexOutOfBoundsException("Invalid Publication Index! ");    
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder(name + "\n");

        for(int i = 0; i < publications.size(); i++){
            info.append(i).append(") ").append(publications.get(i));

        }
        return info.toString();

    }




}


public class LibraryManager{
    public static void main(String[] args){
        Library library = new Library("UTA Central Library");

        library.addPublication(new Publication("Da Vinci Code", "Dan Brown", 2003));
        library.addPublication(new Publication("The Godfather", "Mario Puzo", 1969));
        library.addPublication(new Publication("All The Light We Cannot See", "Anthony Doerr", 2014));
        System.out.println(library);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Which book to check out? ");
        int index;

        try{
            index= scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid index.");
            return;
        }
        System.out.print("Who are you? ");
        String patronName = scanner.nextLine();

        try {
            library.checkOut(index, patronName);
            System.out.println("Book checked out successfully.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index. Please select a valid index.");
        }

        System.out.println(library);

        
    }

}