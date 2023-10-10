package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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

     public class InvalidCheckInException extends RuntimeException {
        public InvalidCheckInException(String message) {
            super(message);
        }
    }
    public Publication(String title, String author, int copyright){
        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Invalid copyright year");

        this.title = title;
        this.author = author;
        this.copyright = copyright;


    }

    public Publication(BufferedReader br) throws IOException{
        this.title = br.readLine();
        this.author = br.readLine();
        this.copyright = Integer.parseInt(br.readLine());
        String fourthLine = br.readLine();
        if ("checked in".equals(fourthLine)){
            loanedTo = null;
            dueDate = null;
        } else {
            loanedTo = br.readLine();
            dueDate = LocalDate.parse(br.readLine());
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        /*bw.write(title);
        bw.newLine();
        bw.write(author);
        bw.newLine();
        bw.write(Integer.toString(copyright));*/
        bw.write( title + '\n');
        bw.write( "" + author + '\n');
        bw.write( "" + copyright + '\n');
        if (loanedTo == null){
            bw.write("checked in\n");
            //bw.write('\n');
        } else {
            bw.write("checked out\n");
            bw.write("" + loanedTo + '\n');
            bw.write("" + dueDate.toString() + '\n');
        }
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
        if ( loanedTo == null || dueDate == null){
            throw new InvalidCheckInException("Publication index not checked out");
        }
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
            stringInfo.append("\n    :").append(" loaned to ").append(loanedTo).append(" until ").append(dueDate);
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