
import java.util.*;

public class Answer {
    
    public static void main(String args[]) { 
        // 12 => 9, 1, 1, 1
        // Dynamic programming
        // This is so cool!!!

        int area = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> dl = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i <= area; i++) {
            dl.add(new ArrayList<Integer>());
            if (i == 0) {
                // do nothing
            }
            else if (i == 1) {
                dl.get(i).add(1);
            }
            else {
                if (Math.sqrt(i) % 1 == 0) {
                    dl.get(i).add(i);
                }
                else {
                    dl.get(i).add(dl.get(i-1).get(0));
                    dl.get(i).addAll(dl.get(i - dl.get(i-1).get(0)));
                }
            }
           
        }
        
         for(Integer s : dl.get(area)) {
                System.out.println(s);
            }
        
       
    }
    // 16 => 16
    // 15 => 9 4 1 1
    // 14 => 9 4 1
    // 13 => 9 4
    // 12 => 9 1 1 1
    // 11 => 9 1 1
    // 10 => 9 1
    // 9 => 9 (sqrt of 9 or 4 4 1 )
    // 8 => 4 4 (sqrt of 8 or first index + recurse (remainder))
    // 7 => 4 1 1 1 
    // 6 => 4 1 1
    // 5 => 4 1
    // 4 => 4
    // 3 => 1 1 1
    // 2 => 1 1
    // 1 => 1 (sqrt of curr or last one + 1)
 
}