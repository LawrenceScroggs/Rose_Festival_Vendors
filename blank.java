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
