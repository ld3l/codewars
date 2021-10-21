/*
###TASK###
At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.

        The restriction is that the characters in part1 and part2 should be in the same order as in s.

        The interviewer gives you the following example and tells you to figure out the rest from the given test cases.

        For example:

        'codewars' is a merge from 'cdw' and 'oears':

        s:  c o d e w a r s   = codewars
        part1:  c   d   w         = cdw
        part2:    o   e   a r s   = oears
###SOLUTION###
The solution based on pure recursion will be much shorter, but it can lead to performance losses due to unnecessary substring operations
*/
public class MergedStringChecker {

    public static boolean isMerge(String s, String part1, String part2) {
        char[] sc = s.toCharArray();
        char[] pt1 = part1.toCharArray();
        char[] pt2 = part2.toCharArray();

        if (part1.length() + part2.length() != s.length()) {
            return false;
        }

        int pt1n = 0;
        int pt2n = 0;

        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (pt1n < pt1.length && pt2n < pt2.length) {
                char pc1 = pt1[pt1n];
                char pc2 = pt2[pt2n];
                if (c == pc1 && c == pc2) {
                    return isMerge(s.substring(i + 1), part1.substring(pt1n + 1), part2.substring(pt2n)) || isMerge(s.substring(i + 1), part1.substring(pt1n), part2.substring(pt2n + 1));
                }

                if (c != pc1 && c != pc2) {
                    return false;
                }
            }

            if (pt1n < pt1.length) {
                char pc1 = pt1[pt1n];
                if (c == pc1) {
                    pt1n++;
                    continue;
                }
            }
            if (pt2n < pt2.length) {
                char pc2 = pt2[pt2n];
                if (c == pc2) {
                    pt2n++;
                    continue;
                }
            }
            return false;

        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "code", "wars") + "true");
        System.out.println(isMerge("codewars", "cdwr", "oeas") + "true");
        System.out.println(isMerge("codewars", "cod", "wars") + "false");
        System.out.println(isMerge("5Y%xFTb@M@6&l\\a", "Y@&a", "5%xFTb@M6l\\") + "true");
        System.out.println(isMerge("abc", "ab", "a") + "false");

    }
}
