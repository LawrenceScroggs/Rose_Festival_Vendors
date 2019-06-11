public class b_tree {

    protected tree_node root;
    protected vendor head;
    protected tree_node prev;
    protected boolean is_parent;


    public int print_tree(){

        if(root == null) return -1;


        else {
            tree_node current = this.root;
            System.out.println("Printing Tree: ");
            print_tree(current);
        }

        return 1;
    }
    protected int print_tree(tree_node current){

        if(current == null)
            return 1;


        print_tree(current.go_left());
        current.print_node();
        print_tree(current.go_mid());
        current.print_node();
        print_tree(current.go_right());

        return 0;
    }
    public int build_tree(vendor_build temp){

        vendor first = temp.rear.get_next();

        vendor_build.rear.display_info();

        insert(vendor_build.rear);

        while(first != vendor_build.rear){

            first.display_info();
            insert(first);
            first = first.get_next();

        }

        return 1;

    }
    protected int split(tree_node current, tree_node prev, vendor node) {


        System.out.println("Splitting");
        if (prev == null) {

            if (node.root_number() > this.root.slot[1].root_number()) {

                tree_node a_right = new tree_node(node);
                tree_node a_left = new tree_node(root.slot[0]);
                this.root.set_right(a_right);
                this.root.set_left(a_left);
                this.root.slot[0] = null;
                return 1;
            } else if (node.root_number() < this.root.slot[0].root_number()) {

                tree_node a_left = new tree_node(node);
                this.root.set_left(a_left);
                vendor temp = this.root.slot[0];
                tree_node a_right = new tree_node(root.slot[1]);
                this.root.set_right(a_right);
                this.root.slot[1] = temp;
                this.root.slot[0] = null;
                return 2;
            } else {

                tree_node a_left = new tree_node(root.slot[0]);
                this.root.set_left(a_left);
                tree_node a_right = new tree_node(root.slot[1]);
                this.root.set_right(a_right);
                this.root.slot[1] = node;
                this.root.slot[0] = null;
                return 3;

            }
        } else {

            current.is_parent = true;

            if (current.slot[1].root_number() < node.root_number()) {

                if (current.slot[1].root_number() < prev.slot[1].root_number()) {

                    prev.slot[0] = current.slot[1];
                    tree_node a_left = new tree_node(current.slot[0]);
                    prev.set_left(a_left);
                    if (node.root_number() > prev.slot[1].root_number()) {
                        tree_node a_right = new tree_node(node);
                        prev.set_right(a_right);
                    }
                    else {
                        tree_node a_mid = new tree_node(node);
                        prev.set_mid(a_mid);
                    }

                    return 1;
                } else {

                    vendor hold = prev.slot[1];
                    prev.slot[1] = current.slot[1];
                    prev.slot[0] = hold;
                    tree_node a_right = new tree_node(node);
                    prev.set_right(a_right);
                    if (current.slot[0].root_number() < prev.slot[0].root_number()) {
                        tree_node a_left = new tree_node(current.slot[0]);
                        prev.set_left(a_left);
                        return 1;
                    }
                    else {
                        tree_node a_mid = new tree_node(current.slot[0]);
                        prev.set_mid(a_mid);
                        return 2;
                    }

                }
            } else if (node.root_number() < current.slot[0].root_number()) {

                if (current.slot[0].root_number() < prev.slot[1].root_number()) {

                    prev.slot[0] = current.slot[0];
                    tree_node a_left = new tree_node(node);
                    prev.set_left(a_left);
                    if (current.slot[1].root_number() > prev.slot[1].root_number()) {

                        tree_node a_right = new tree_node(current.slot[1]);
                        prev.set_right(a_right);
                    }
                    else {
                        tree_node a_mid = new tree_node(current.slot[1]);
                        prev.set_mid(a_mid);
                    }

                    return 1;
                } else {

                    vendor hold = prev.slot[1];
                    prev.slot[1] = current.slot[0];
                    prev.slot[0] = hold;
                    tree_node a_right = new tree_node(current.slot[1]);
                    prev.set_right(a_right);
                    if (node.root_number() < prev.slot[0].root_number()) {
                        tree_node a_left = new tree_node(node);
                        prev.set_left(a_left);
                    }
                    else {
                        tree_node a_mid = new tree_node(node);
                        prev.set_mid(a_mid);
                    }

                    return 2;

                }


            } else {

                if (node.root_number() < prev.slot[1].root_number()) {

                    prev.slot[0] = node;
                    tree_node a_left = new tree_node(current.slot[0]);
                    prev.set_left(a_left);
                    if (current.slot[1].root_number() > prev.slot[1].root_number()) {

                        tree_node a_right = new tree_node(current.slot[1]);
                        prev.set_right(a_right);
                        return 1;
                    }
                    else {
                        tree_node a_mid = new tree_node(current.slot[1]);
                        prev.set_mid(a_mid);
                        return 2;
                    }

                } else {

                    vendor hold = prev.slot[1];
                    prev.slot[1] = node;
                    prev.slot[0] = hold;
                    tree_node a_right = new tree_node(current.slot[1]);
                    prev.set_right(a_right);
                    if (current.slot[0].root_number() < prev.slot[0].root_number()) {
                        tree_node a_left = new tree_node(current.slot[0]);
                        prev.set_left(a_left);
                        return 1;
                    }
                    else {
                        tree_node a_mid = new tree_node(current.slot[0]);
                        prev.set_mid(a_mid);
                        return 2;
                    }

                }

            }

        }


    }

    public int insert(vendor node) {


        if (this.root == null) {

            System.out.println("In here");
            this.root = new tree_node(node);

            prev = null;

            return 0;

        }

        else {
            System.out.println("Moving 1");
            tree_node current = this.root;
            insert(current, prev, node);
            return 1;
        }


        /*if (this.root.slot[1] == null) {

                this.is_parent = true;
                this.root.slot[1] = node;
                return 0;

            } else if (compare < root.slot[1].root_number()) {

                this.root.slot[0] = node;
                return 1;

            } else if (compare > root.slot[1].root_number()) {

                vendor temp = this.root.slot[1];
                this.root.slot[1] = node;
                this.root.slot[0] = temp;
                return 2;
            } else
                split(this.root, prev, node);
            return 3;
        } else {

            System.out.println("moving 1");
            prev = this.root;

            if(this.root.slot[0] != null) {
                if (this.root.slot[0].root_number() > node.root_number()) {
                    tree_node current = this.root;
                    current = current.go_left();
                    insert(current, prev, node);
                    return 0;
                } else if (this.root.slot[1].root_number() > node.root_number()) {
                    tree_node current = this.root;
                    current = current.go_right();
                    insert(current, prev, node);
                    return 1;
                } else {
                    tree_node current = this.root;
                    current = current.go_mid();
                    insert(current, prev, node);
                    return 2;
                }
            }
            else{
                if (this.root.slot[1].root_number() > node.root_number()){

                    tree_node current = this.root;
                    current = current.go_left();
                    insert(current,prev,node);
                    return 1;
                }
                else{
                    tree_node current = this.root;
                    current = current.go_right();
                    insert(current,prev,node);
                    return 2;
                }
            }
        }*/

    }

    protected int insert(tree_node current, tree_node prev, vendor node) {

        if(current.go_left() == null && current.go_right() == null && current.go_mid() == null) {

            if (current.slot[0] == null || current.slot[1] == null) {

                System.out.println("In here now");

                if (current.slot[1] == null)
                    current.slot[1] = node;

                else if (current.slot[1] != null) {

                    if (node.root_number() > current.slot[1].root_number()) {

                        current.slot[0] = current.slot[1];
                        current.slot[1] = node;
                    } else
                        current.slot[0] = node;

                    return 1;
                } else {
                    current.slot[0] = current.slot[1];
                    current.slot[1] = node;
                }
                return 1;
            } else if (current.slot[0] != null && current.slot[1] != null) {

                split(current, prev, node);
                return 2;

            }
            return 1;
        }
        else {

            System.out.println("Moving 2");
            prev = current;

            if(current.slot[0] != null) {
                if (current.slot[0].root_number() > node.root_number()) {
                    current = current.go_left();
                    insert(current, prev, node);
                    return 0;
                } else if (this.root.slot[1].root_number() > node.root_number()) {
                    current = current.go_right();
                    insert(current, prev, node);
                    return 1;
                } else {
                    current = current.go_mid();
                    insert(current, prev, node);
                    return 2;
                }
            }
            else{
                if (current.slot[1].root_number() > node.root_number()){
                    current = current.go_left();
                    insert(current,prev,node);
                    return 1;
                }
                else{
                    current = current.go_right();
                    insert(current,prev,node);
                    return 2;
                }
            }
        }
    }


    public b_tree(){

        this.root = null;
        this.head = null;
        this.prev = null;
        this.is_parent = false;

    }
}
