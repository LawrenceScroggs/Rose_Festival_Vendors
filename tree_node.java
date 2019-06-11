public class tree_node {

    protected tree_node right;
    protected tree_node left;
    protected tree_node mid;
    protected vendor [] slot;
    protected boolean is_parent;


    public int print_node(){

        int x = 0;
        while(slot[x] != null){

            slot[x].display_info();
            ++x;
        }
        return x;
    }
    public void set_mid(tree_node obj){

        this.mid = obj;

    }
    public tree_node go_mid(){

        return this.mid;
    }
    public void set_left(tree_node obj){

        this.left = obj;

    }
    public tree_node go_left(){

        return this.left;

    }
    public void set_right(tree_node obj){

        this.right = obj;

    }
    public tree_node go_right(){

        return this.right;

    }
    public tree_node(vendor obj){

        this.right = null;
        this.left = null;
        this.mid = null;

        slot = new vendor[3];

        for (int i = 0; i < 3; ++i) {

            slot[i] = null;

            right = null;
        }
        slot[1] = obj;
        is_parent = false;

    }
    public tree_node() {

        this.right = null;
        this.left = null;
        this.mid = null;

        slot = new vendor[3];

        for (int i = 0; i < 3; ++i) {

            slot[i] = null;

            right = null;
        }

        is_parent = false;
    }

}
