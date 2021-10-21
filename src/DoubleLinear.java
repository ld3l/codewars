import java.util.Stack;


/*
###TASK###

Description:
Consider a sequence u where u is defined as follows:

The number u(0) = 1 is the first one in u.
For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
There are no other numbers in u.
Example:
u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...

Task:
Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the ordered sequence u (ordered with < so there are no duplicates) .

Example:
dbl_linear(10) should return 22

*/

class DoubleLinear {

    public static int dblLinear(int n) {
        Stack<Integer> sequence = new Stack<>();
        sequence.push(1);

        int countY = 0;
        int countZ = 0;
        int countYZ = 0;

        while (countY + countZ < n + countYZ) {
            int y = 2 * sequence.get(countY) + 1;
            int z = 3 * sequence.get(countZ) + 1;
            if (y < z) {
                sequence.push(y);
                countY++;
            } else if (y > z) {
                sequence.push(z);
                countZ++;
            } else {
                sequence.push(y);
                countY++;
                countZ++;
                countYZ++;
            }
        }
        return sequence.peek();
    }

    public static void main(String[] args) {
        System.out.println(dblLinear(10) + "22");
        System.out.println(dblLinear(20) + "57");
        System.out.println(dblLinear(30) + "91");
    }
}