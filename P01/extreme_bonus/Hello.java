    import java.util.Scanner;

    public class Hello {

        public static void main(String[] args){
            String userName = System.getProperty("user.name");
            if(userName != null){
                System.out.println("Hello " + userName);
            }
            else{
                System.out.println("Hello, world");
            }

        }
    }
