package library;
import java.time.LocalDate;

/**
 * Represents a publication ( a book or a video)
 */

public class Publication{


    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;
    /**
     * Constructs a new publication using the specified title, author and copyright . 
     * @param title         The title of the publication
     * @param author        The author of the publication
     * @param copyright     The copyright of the publication
     */

    public Publication(String title, String author, int copyright){
        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Invalid copyright year");

        this.title = title;
        this.author = author;
        this.copyright = copyright;


    }
    /**
     * checks out the publication to the  patron and sets the duedate.
     * @param patron        name of the patron who checks out the publication.
     * 
     */

    public void checkOut(String patron){
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void checkIn(){
        loanedTo = null;
        dueDate = null;
    }    
    /**
     * Represents  string represention of the publication 
     * @param pre       Prefix for either book or video
     * @param mid       Additional publication informtaion if pre is video or null if book
     * @return          string representing the publication. 
     */

    protected String toStringBuilder(String pre, String mid){
        StringBuilder stringInfo = new StringBuilder(pre);

        stringInfo.append(" \"").append(title).append("\" by the author ").append(author).append(" ,copyright: ").append(copyright);
        
        if(mid != null){
            stringInfo.append(", ").append(mid);
        }
        if(loanedTo != null){
            stringInfo.append("\n    :").append(" loaned to").append(loanedTo).append(" until ").append(dueDate);
        }

        stringInfo.append("\n");
        return stringInfo.toString();
    }
    /**
     * Returns string represention of the publication i.e a book
     * @return a string containing details of the book.
     */

    @Override
    public String toString(){
        return toStringBuilder("Book", "");    
    }
    
}