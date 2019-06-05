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

        genre = null;
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
