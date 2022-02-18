import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

public class Visual {
    //TODO Reused code from the previous assigment and patched with the required modifications.
    // As this is very similar to what I already did it was a reuse of my own code.
    public static void choices() {
        Scanner scanChoice = new Scanner(System.in);
        System.out.println("Please select one of the following options:");
        System.out.println("'+' -> Addition");
        System.out.println("'*' -> Multiplication");
        System.out.println("'P' -> To pop the Stack");
        System.out.println("'?' -> Print the Stack");
        System.out.println("Any number (Integer)-> Add number to the Stack");
        System.out.println("'$' -> To quit");
        String select = scanChoice.nextLine();
        if (NumberUtils.isNumber(select)) {
            Stack.stackLl.push(Integer.parseInt(select));
            System.out.println("You've entered " + select + " it will be added to the stack.");
            choices();
        }
        else {
            selectionMenu(select.toUpperCase());
        }
    }

    public static void selectionMenu(String s) {
        switch (s) {
            case "+": {
                //TODO Added the Stack.size() for nodes and this confirm that the stack is of size 2 or more.
                int addVal1 = 0;
                int addVal2 = 0;
                int i = 0;
                Stack.Node temp = Stack.stackLl.top;
                if (temp != null && temp.size() < 2)  {
                    System.out.println("There are not enough numbers to sum them up. \r");
                    choices();
                } else {
                    while (temp.next != null) {
                        temp = temp.next;
                        if (temp.next == null && i == 0) {
                            addVal1 = (int) Stack.stackLl.pop();
                            i++;
                        }
                        if (temp.next == null && i == 1) {
                            addVal2 = (int) Stack.stackLl.pop();
                            i++;
                        }
                    }
                    int sumPop = addVal1 + addVal2;
                    System.out.println("The sum of the top item of the stack is: " + addVal1 + " + " + addVal2 + " = " + sumPop);
                    Stack.stackLl.push(sumPop);
                }
                choices();
            }
            case "*": {
                int multiplyVal1 = 0;
                int multiplyVal2 = 0;
                int i = 0;
                Stack.Node temp = Stack.stackLl.top;
                if (temp != null && temp.size() < 2) {
                    System.out.println("There are not enough numbers to multiply them up. \r");
                    choices();
                } else {
                    while (temp.next != null) {
                        temp = temp.next;
                        if (temp.next == null && i == 0) {
                            multiplyVal1 = (int) Stack.stackLl.pop();
                            i++;
                        }
                        if (temp.next == null && i == 1) {
                            multiplyVal2 = (int) Stack.stackLl.pop();
                            i++;
                        }
                    }
                    int multiplyPop = multiplyVal1 * multiplyVal2;
                    System.out.println("The sum of the top item of the stack is: " + multiplyVal1 + " X " + multiplyVal2 + " = " + multiplyPop);
                    Stack.stackLl.push(multiplyPop);
                }
                choices();
            }
            case "P": {
                System.out.println("The following value was removed: " + Stack.stackLl.pop() + "\r");
                choices();
            }
            case "?": {
                System.out.println("Here's the list of all the numbers that are part of the stack: " + Stack.stackLl);
                choices();
            }
            case "$": {
                System.out.println("Good bye!");
                System.exit(200);
            }
            default:
                System.out.println("Well Well Well That's not good");
                choices();
        }

    }
}