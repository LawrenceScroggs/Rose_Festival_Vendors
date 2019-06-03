public class vendor {

    protected String name;
    protected vendor next;
    protected boolean is_empty;


    public vendor(){

        name = null;
        next = null;
        is_empty = true;

    }

    public vendor get_next(){

        return this.next;
        
    }
}
