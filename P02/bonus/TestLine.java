public class TestLine{
    public static void main(String[] args){
        Line line1 = new Line(9.264, 8.626, 9.070, 3.194, Color.INDIGO);
        Line line2 = new Line(5.670, 0.307, 4.001, 8.058, Color.GREY);
        Line line3 = new Line(9.360, 6.226, 4.605, 4.110, Color.WHITE);
        Line line4 = new Line(0.752, 9.955, 5.561, 9.962, Color.SILVER);


        
        System.out.println(line1 +" has Length: " + line1.length());
        

        
        System.out.println(line2 +" has Length: " + line2.length());

        
        System.out.println(line3 +" has Length: " + line3.length());

        
        System.out.println(line4 +" has Length: " + line4.length());

    }
}

