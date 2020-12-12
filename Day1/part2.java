import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class part2 {
    public static void main(String[] args) {
        try {
            ArrayList<ArrayList<Integer>> expenseLists = new ArrayList<ArrayList<Integer>>(5);
            for (int i = 0; i < 5; i++) {
                expenseLists.add(new ArrayList<Integer>());
            }
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
            String temp;
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                expenseLists.get(temp.length()).add(Integer.parseInt(temp));
            }
            for (int i = 1; i < 5; i++) {
                Collections.sort(expenseLists.get(i));
                expenseLists.get(0).addAll(expenseLists.get(i));
            }

            int k = expenseLists.get(0).size();
            int target;
            int j;
            System.out.println(expenseLists.get(0));
            while(k > 0){
                k--;
                target = 2020 - expenseLists.get(0).get(k);
                j = k - 1;
                for(int i = 0; i < j; i++){
                    if(expenseLists.get(0).get(i) + expenseLists.get(0).get(j) >= target){
                        if(expenseLists.get(0).get(i) + expenseLists.get(0).get(j) > target){
                            if(i > 0){
                                i -= 2;
                            }
                            j--;
                        } else{
                            System.out.println(expenseLists.get(0).get(k));
                            System.out.println(expenseLists.get(0).get(j));
                            System.out.println(expenseLists.get(0).get(i));
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}