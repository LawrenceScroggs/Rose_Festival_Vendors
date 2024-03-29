/* Lawrence Scroggs Program 4 CS202 06/01/19
This class holds the carnival type vendor.  This class is used to inform organizer that it
is used in a carnival setting along with its name and type e.g. (rollercoaster, games, face paint, etc)
This is an extension from the abstract base class and gets some of its members and data from there.
 */



import java.util.Scanner;

public class carnival extends vendor {

    protected String attraction;
    protected vendor next;
    protected boolean is_carnival;

    public carnival(){

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the name of carnival attraction: ");
        name = in.nextLine();
        System.out.print("Please enter the type of carnival attraction: ");
        attraction = in.nextLine();
        next = null;
        is_carnival = true;

    }
    public carnival(String thing,int i){

        System.out.print("Please enter the Name of the carnival attraction: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        attraction = thing;
        is_carnival = true;
        next = null;

    }
    public int display_info(){

        System.out.print("Vendor: ");
        System.out.println(name);
        System.out.print("Attraction: ");
        System.out.println(attraction);
        System.out.println();

        return 1;
    }

    public vendor get_next(){

        return this.next;

    }
    public void set_next(vendor next){

        this.next = next;
    }
}
