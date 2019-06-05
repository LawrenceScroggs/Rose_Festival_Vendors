
public abstract class vendor {

    protected String name;
    protected vendor next;



    public vendor(){

        name = null;
        next = null;

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
