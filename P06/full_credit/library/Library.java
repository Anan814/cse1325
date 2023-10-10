package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;



/**
 * Library class that manages a collection of publications (Books and Videos)
 */
public class Library{

    private String name;
    private ArrayList<Publication> publications = new ArrayList<>() ;
    /**
     * initalises new instance of the library class with the given name
     * @param name      name of the Library
     */
    public Library(String name){
        this.name = name;
        //this.publication  
    }

    public Library(BufferedReader br) throws IOException{
        //this.name = br.readLine();
        this.name = br.readLine();
        int numOfPublications = Integer.parseInt(br.readLine());
        publications.clear();

        for (int i = 0; i < numOfPublications; i++){
            String oType = br.readLine();

            if("video".equals(oType)){
                Video video = new Video(br);
                publications.add(video);
            } else {
                Publication publication = new Publication(br);
                publications.add(publication);
            }

        }
    }
    

    public void save (BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write("" + publications.size() + '\n');

        for(Publication publication : publications){
            /*bw.newLine();
            bw.write(publication.getClass().getName());
            bw.newLine();
            publication.save(bw);*/
            if ( publication instanceof Video){
                bw.write("video\n");
            } else {
                bw.write("publication\n");
            }

            publication.save(bw);
        }
    }
    /**
     * adds publication to library collection
     * @param publication   the publication of the library. 
     */
    public void addPublication(Publication publication){
        publications.add(publication);
    }
    /**
     * Checks out publication from the library using the index
     * @param publicationIndex              the index of the publication to be checked out.
     * @param patron                        name of the patron checking out.
     * @throws IndexOutOfBoundsException    if publication index is invalide.                                                                 
     */
    public void checkOut(int publicationIndex, String patron){
        if(publicationIndex >= 0 && publicationIndex < publications.size())
            publications.get(publicationIndex).checkOut(patron);
        else
            throw new IndexOutOfBoundsException("Invalid Publication Index! ");    
    }

    public void checkIn( int publicationIndex){
        publications.get(publicationIndex).checkIn();

    }

    /**
     * Returns a string that represents the library publications.
     * @return    a String containing the list of library publications.
     */
    @Override
    public String toString(){
        StringBuilder info = new StringBuilder(name + "\n");

        for(int i = 0; i < publications.size(); i++){
            info.append(i).append(") ").append(publications.get(i));

        }
        return info.toString();

    }
}