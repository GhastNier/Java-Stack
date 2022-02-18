public class Stack {
    //TODO used https://www.geeksforgeeks.org/data-structures/linked-list/ for help as I did for last Assigment.
    // I wanted to make sure that I was grasping the subject. Used most of the code from the previous assignment.
    // Changed the code from add() to become push() and place the new node at the top of the list(Stack).
    public static Node top;

    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
        }
        public int size() {
            int listSize = 0;
            Node temps = top;
            while (temps != null) {
                listSize++;
                temps = temps.next;
            }
            return listSize;
        }

    }

    static Stack stackLl = new Stack();
//TODO The main calls the Visual.choices() method, which is the whole user interface containing the switch for actions.
    public static void main(String[] args) {
        Visual.choices();
    }
    static void push(int value) {
        Node temp = new Node(value);
        if (temp == null) {
            top = temp;
        }
        temp.next = top;
        top = temp;
    }

    //TODO Here what is done : the value of the Top is stored and returned it is then used in the Visual Class
    // to sum and multiply. Doing so let's me print the value each time there's a pop() called under the "P" user entry.
    static Object pop() {
        int popData = 0;
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            popData = top.value;
            top = top.next;
        }
        if (popData == 0){
        top = null;
        System.out.print((Object) null);
        }
        return popData;
    }
    //TODO Taken from previous assignment, no change here.
    @Override
    public String toString() {
        Node now = top;
        String list = "";
        while (now != null) {
            list = list + now.value + " ";
            now = now.next;
        }
        if (list.equals("")) return "The stack doesn't contain any numbers";
        else {
            return list;
        }
    }
}