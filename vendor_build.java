import java.util.Scanner;

public class vendor_build {

    protected String read;
    protected vendor rear;
    protected int num_vens;
    protected String[] g_array;

    public static void main(String[] args) {

        vendor_build festival = new vendor_build();

        festival.display();

        festival.add_vendor();

        festival.display();


    }

    public int display() {

        if (rear == null) return -1;

        vendor current = this.rear;

        display(current);

        return 1;
    }

    protected int display(vendor current) {

        if (current == null){
            return -1;
        }

        else {
            System.out.print("Vendor: ");

            System.out.println(current.name);

            current = current.get_next();

            display(current);
        }

        return 1;

    }

    protected int fill_CLL(vendor obj) {

        if (this.rear.name.equals("Blank")) {

            System.out.println("made a new");
            rear = obj;
            System.out.println(rear.name);
            return 2;

        } else {
            fill_CLL(rear.get_next());
            return 1;
        }

    }

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

    protected int CLL(vendor obj) {


        if(rear.name.equals("Blank")){

            obj.next = rear.next;
            this.rear = obj;
        }
        else{
            vendor current = this.rear;
            CLL(current,obj);
        }

        return 1;

    }

    protected int CLL(vendor current, vendor obj){

        if(current == null) return -1;

        if(current.name.equals("Blank")){

            System.out.println("curr");
            obj.next = current.next;
            current = obj;
            System.out.println(current.name);
            return 1;
        }
        else
            current = current.get_next();

        CLL(current,obj);
        return 1;
    }




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
                    vendor current = new music(m_type, i);
                    CLL(current);
                }
            }
            return 1;
        }
        else if(type.equals("FOOD")) {

            int i = -1;
            while (i <= -1) {
                System.out.print("Please enter the type of food. ");
                String m_type = get_read();

                i = array_handle(m_type);
                if (i > -1) {
                    vendor current = new music(m_type, i);
                    CLL(current);
                }
                return 1;
            }
        }
        else if(type.equals("CARNIVAL")) {

            int i = -1;
            while (i <= -1) {
                System.out.print("Please enter the type of carnival entertainment.");
                String m_type = get_read();

                i = array_handle(m_type);
                if (i > -1) {
                    vendor current = new music(m_type, i);
                    CLL(current);
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
