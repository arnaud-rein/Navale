package bataille.navale;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("AROUND THE WORLD!");
        
        Grid joueur1 = new Grid("arnaud");
        

        System.out.println(joueur1.name);

        joueur1.demanderTaille();
        // joueur1.placerNavire();
        // joueur1.placerLeNavireDeGuerre();
        joueur1.placerToutLesNavires();
        joueur1.afficherGrid();
        joueur1.recevoirTorpille();
        joueur1.afficherGridDeRoute();
        // joueur1.recevoirTorpille();


        // joueur1.testDouble();






        // TEST D'UNE CONDITION TERNAIRE

        // System.out.println("test du if ternaire");
        
        // int nb1 = 5;
        // int nb2 = 8;
        // int nb3 = 10;

        // int str = nb1 > 10 ? nb2 : nb3; 

        // System.out.println(str);
        




    
 
// try  
// {  
// //the file to be opened for reading  
// FileInputStream fis=new FileInputStream("Demo.txt");       
// Scanner sc=new Scanner(fis);    //file to be scanned  
// //returns true if there is another line to read  
// while(sc.hasNextLine())  
// {  
// System.out.println(sc.nextLine());      //returns the line that was skipped  
// }  
// sc.close();     //closes the scanner  
// }  
// catch(IOException e)  
// {  
// e.printStackTrace();  
// }  




















    }
}
