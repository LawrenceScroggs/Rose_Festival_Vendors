import java.util.Scanner;

public class music extends vendor{

    protected String genre;
    protected boolean is_music;



    public void set_next(vendor obj){

        this.next = obj.next;
    }
    public vendor get_next(){

        return this.next;
    }
    public music(){

        genre = null;
        is_music = true;
    }
    public music(String thing,int i){

        System.out.print("Please enter the name of the Musician or Band: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        genre = thing;
        is_music = true;

    }
}
