
/* Lawrence Scroggs Program 4 CS202 06/01/19
This is the abstract base class.  Four other classes are going to sprout from this class.  This class holds the
information of name and the information that will allow the CLL to be built.  The display info, set next and get next
will all be overridden by it's subclasses.
 */
public abstract class vendor {

    protected String name;

    protected vendor next;

    public vendor(){

        this.name = null;
        this.next = null;

    }
    public int root_number(){

        char [] array = name.toCharArray();

        return (array[0] + array[1]);
    }

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
}
