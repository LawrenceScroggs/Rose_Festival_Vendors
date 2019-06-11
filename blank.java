
/* Lawrence Scroggs Program 4 CS202 06/01/19
This class holds the blank type sub class.  This class is just used as a holder when first building the
layout of the vendors.  The idea is to have the vendor map built and switch blanks out with appropriate vendors.
This is an extension from the abstract base class and gets some of its members and data from there.
 */

public class blank extends vendor {

    protected boolean is_blank;


    public int display_info(){

        System.out.print("Vendor: ");
        System.out.println(name);
        System.out.println();

        return 1;
    }
    public vendor get_next(){

        return this.next;

    }
    public void set_next(vendor next){

        this.next = next;
    }
    public blank(){

        is_blank = true;
        name = "Blank";
        next = null;
    }
}
