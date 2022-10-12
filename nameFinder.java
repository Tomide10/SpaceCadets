import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class nameFinder{
    public static void main(String[] args)throws Exception{
        System.out.println("Enter ID:");
        BufferedReader id = new BufferedReader(new InputStreamReader(System.in)); //Takes input from the keyboard and stores the id of the person to be found

        String address = "https://www.southampton.ac.uk/people/" + id.readLine();   //Creates a URL with the id
        URL page = new URL(address);

        BufferedReader homePage = new BufferedReader(new InputStreamReader(page.openStream())); //Opens a stream to the source of the web page

        for (int i =0;i<13;i++){    //Cycles through the first 13 lines of HTML to get to the line with the name.
            homePage.readLine();
        }
        
        String nameLine = homePage.readLine();
        int endIndex = nameLine.indexOf("/")-2;

        String name = nameLine.substring(35, endIndex); //isolates the name from the rest of the line 
        System.out.println(name);

    }
}