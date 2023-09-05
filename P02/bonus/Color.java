 public enum Color { INDIGO(75,0,130), 
    GREY(128, 128, 128), 
    WHITE(255, 255, 255), 
    SILVER(192, 192, 192);

    private final int red;
    private final int green;
    private final int blue;

    private Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public String toString(){
        return this.name() + "(0x" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue) + ")";
    }
   
    
 }