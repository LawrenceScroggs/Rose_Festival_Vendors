import java.util.Scanner;

public class food extends vendor {

    protected String food_type;
    protected boolean is_food;


    public vendor get_next(){

        return this.next;

    }
    public void set_next(vendor next){

       this.next = next;

    }
    public int display_info() {

        System.out.print("Vendor: ");
        System.out.println(name);
        System.out.print("Food Type: ");
        System.out.println(food_type);
        System.out.println();

        return 1;
    }

    public food(){


        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the name of Restaurant: ");
        name = in.nextLine();
        System.out.print("Please enter the type of food served: ");
        food_type = in.nextLine();
        next = null;
        is_food = true;

    }
    public food(String thing, int x){


        System.out.print("Please enter the Name of Restaurant: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        food_type = thing;
        is_food = true;
        next = null;
    }
}
