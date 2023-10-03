package library;
import java.time.Duration;


/**
 * Represents a video publication
 */
public class Video extends Publication{
    private Duration runtime;
    /**
     * constructs a new video with the specified title, author, copyright and runtime.
     * @param title         the title of the video
     * @param author        the name of the director for the video
     * @param copyright     the copyright of the video
     * @param runtime       the runtime duration of the video
     */
    public Video(String title, String author, int copyright, int runtime){
        super(title, author, copyright);
        this.runtime = Duration.ofMinutes(runtime);
        
        if( runtime <= 0){
            throw new InvalidRuntimeException(title, runtime);
        }
    }
    /**
     * custom exception class that prints an exception message, a subclass of ArithmeticException class
     */
    public static class InvalidRuntimeException extends ArithmeticException{
        /**
         * Constructs an ArithemeticException with no detail message.
         */
        public InvalidRuntimeException(){
             super();
        }
        /**
         * Constructs an ArithemeticException with the specified detailed message.
         * @param s     the detailed message.
         */
        public InvalidRuntimeException(String s){
             super(s);
        }

        /**
         * Constructs an InvalidRuntimeException with a message consisting of video title and runtime
         * @param title     name of the video where runtime error occurs.
         * @param runtime   value of the runtime of the video where the error occurs.
         */
        public InvalidRuntimeException(String title, int runtime){
            super( title + " has invalid runtime " + runtime );
        }
    }
    /**
     *@return   returns string representation for Video
     */
    @Override
    public String toString(){
        return toStringBuilder("Video", "runtime "+ runtime.toMinutes()+ " minutes");
        
    }
    
}