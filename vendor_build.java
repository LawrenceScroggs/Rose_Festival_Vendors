import java.util.Scanner;
import java.util.*;

public class vendor_build {

    protected String read;
    protected static vendor rear;
    protected int num_vens;
    protected String[] g_array;

    public static void main(String[] args) {

        vendor_build festival = new vendor_build();

        festival.add_vendor();
        festival.display();

        festival.add_vendor();
        festival.display();

        carnival object = new carnival();
        festival.add_new(object);

        festival.display();

        festival.remove_vendor();

        festival.display();

        festival.print_array();


    }
    // prints array
    public int print_array(){

        int i = 0;
        while(g_array[i] != null){

            System.out.print("Vendor Type: ");
            System.out.println(g_array[i]);
            ++i;
        }

        return i;
    }

    // remove a vendor
    public int remove_vendor(){

        System.out.print("Please enter the name of the Vendor you want removed. ");
        String a_vendor = get_read();

        if(this.rear == null) return -1;


        else {
            vendor current = this.rear;
            remove_vendor(current,a_vendor);
        }

        return 1;

    }
    // recursive to find vendor and remove
    public int remove_vendor(vendor current, String a_vendor){

        if(current.get_next().name.equals(rear.name) && current.get_next().name.equals(a_vendor)){

            current.set_next(rear.get_next());
            this.rear = current;
            return 2;
        }

        if(current.get_next().name.equals(a_vendor)){

            current.set_next(current.get_next().get_next());
            return 1;
        }
        else{
            current = current.get_next();
            remove_vendor(current,a_vendor);
        }

        return 1;




    }

    // links up LLL to CLL
    protected int link_up(){

        if(this.rear == null) return -1;

        else{
            vendor current = this.rear;
            link_up(current);
        }
        return 1;
    }
    protected int link_up(vendor current){

        if(current.get_next() == null)
            current.set_next(this.rear);

        else {
            current = current.get_next();

            link_up(current);
        }

        return 1;
    }
    // display wrapper
    public int display() {

        if (rear == null) return -1;

        rear.display_info();

        vendor current = this.rear;

        current = current.get_next();

        display(current);

        return 1;
    }

    //recursive call for display
    protected int display(vendor current) {

        if (current == rear){
            return -1;
        }

        else {

            current.display_info();

            current = current.get_next();

            display(current);
        }

        return 1;

    }

    // add new vendor if needed
    public int add_new(vendor obj){

        int i = array_handle(obj.name);

        if(i <= -1)
            return -1;

        if(this.rear == null) {
            this.rear = obj;
            rear.set_next(rear);
        }
        else{
            vendor current = this.rear;
            add_new(current,obj);
        }

        return 1;

    }
    protected int add_new(vendor current,vendor obj){

        if(current.get_next() == rear){
            obj.set_next(rear);
            current.set_next(obj);
            return 1;
        }
        else{
            current = current.get_next();
            add_new(current,obj);
        }

        return 1;

    }
    // sets up initial vendor path
    protected int build_blank(int x) {

        int count = 0;

        this.rear = new blank();

        while (count < x-1) {

            vendor next = new blank();
            next.set_next(rear);
            this.rear = next;
            ++count;

        }

        return count;

    }

    /* checks the array to see if there is an abundance of certain type of vendor*/
    public int array_handle(String x) {

        int count = 0;
        int i = 0;

        /* sets to upper case */
        x = x.toUpperCase();

        while (i < 50) {


            if (count == 3) {
                System.out.println("Too many of same vendor.");
                return -1;
            } else if (g_array[i] == null && count < 4) {
                g_array[i] = x;
                ++count;
                return i;
            } else if (g_array[i].equals(x)) {
                ++count;
                ++i;
            } else
                ++i;

        }
        return -1;
    }
// Changes vendors in the CLL to update for user
    protected int CLL(vendor obj) {


        if(this.rear.name.equals("Blank")){

            obj.set_next(rear.get_next());
            this.rear = obj;
            link_up();
        }
        else{
            vendor current = this.rear;
            CLL(current,obj);
        }

        return 1;

    }

    // moves throughout list recursively
    protected int CLL(vendor current, vendor obj){

        if(current.get_next() == rear){
            System.out.println("No available slots");
            return -1;
        }

        if(current.get_next().name.equals("Blank")){

            obj.set_next(current.get_next().get_next());
            System.out.println("curr");
            current.set_next(obj);
            return 1;
        }
        else {
            System.out.println("Moving");

            current = current.get_next();
        }
        CLL(current,obj);
        return 1;
    }

    // adds vendor type for user
    public int add_vendor(){

        System.out.print("Please enter the type of vendor you would like to add. ");
        String type = get_read();

        type = type.toUpperCase();


        if(type.equals("MUSIC")){

            int i = -1;
            while (i <= -1) {
                System.out.print("Please enter the genre of music. ");
                String m_type = get_read();

                i = array_handle(m_type);
                if(i > -1) {
                    g_array[i] = m_type;
                    vendor obj = new music(m_type, i);
                    CLL(obj);
                }
            }
            return 1;
        }
        else if(type.equals("FOOD")) {

            int i = -1;
            while (i <= -1) {
                System.out.print("Please enter the type of food service. ");
                String f_type = get_read();

                i = array_handle(f_type);
                if (i > -1) {
                    g_array[i] = f_type;
                    vendor obj = new food(f_type, i);
                    CLL(obj);
                }
                return 1;
            }
        }
        else if(type.equals("CARNIVAL")) {

            int i = -1;
            while (i <= -1) {
                System.out.print("Please enter the type of carnival entertainment. ");
                String c_type = get_read();

                i = array_handle(c_type);
                if (i > -1) {
                    g_array[i] = c_type;
                    vendor obj = new carnival(c_type, i);
                    CLL(obj);
                }
            }
            return 1;
        }
        else {

            System.out.println("Not a type of vendor we accept.");
            return 0;
        }

        return 2;

    }

    public String get_read(){

        Scanner in = new Scanner(System.in);
        this.read = in.nextLine();

        return read;
    }

    //sets rear
    public void set_rear(vendor obj){

        this.rear = obj;
    }

    public vendor_build(){

        Scanner in = new Scanner(System.in);
        System.out.print("How many vendors are expected? ");
        rear = null;
        read = null;

        g_array = new String[100];

        for (int i = 0; i < g_array.length; ++i){

            g_array[i] = null;
        }

        build_blank(this.num_vens = in.nextInt());

    }

}
