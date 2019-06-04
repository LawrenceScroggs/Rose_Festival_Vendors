public class blank extends vendor {

    protected boolean is_blank;

    public boolean return_blank(){

        return is_blank;
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
    }
}
