
/* Lawrence Scroggs Program 4 CS202 06/01/19
This class is the holder for the different music throughout the festival.  This is used to not only store the
Artist info but the genre of music that the artist is involved in as to not put too many of the same type of music
together when planning. This is an extension from the abstract base class and gets some of its members and data from there.
 */

import java.util.Scanner;

public class music extends vendor{

    protected String genre;
    protected boolean is_music;



    public int display_info(){

        System.out.print("Vendor: ");
        System.out.println(name);
        System.out.print("Genre: ");
        System.out.println(genre);
        System.out.println();

        return 1;
    }
    public void set_next(vendor next){

        this.next = next;
    }
    public vendor get_next(){

        return this.next;
    }
    public music(){

        System.out.print("Please enter the name of the Musician or Band: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        System.out.print("Please enter the genre of music: ");
        genre = in.nextLine();
        is_music = true;
        next = null;
    }
    public music(String thing,int i){

        System.out.print("Please enter the name of the Musician or Band: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        genre = thing;
        is_music = true;
        next = null;

    }
}
