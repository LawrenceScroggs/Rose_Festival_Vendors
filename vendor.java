

public class vendor {

    protected String name;
    protected vendor next;

    public vendor(){

        name = null;
        next = null;

    }

    public vendor get_next(){

        return this.next;

    }
    public void set_next(vendor obj){

        this.next = obj.next;
    }
}
