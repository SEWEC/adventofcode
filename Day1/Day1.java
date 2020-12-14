import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {
    public static void main(String[] args){
        try {
            ArrayList<ArrayList<Integer>> expenseLists = new ArrayList<ArrayList<Integer>>(5);
            for(int i = 0; i < 5; i++){
                expenseLists.add(new ArrayList<Integer>());
            }
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
            String temp;
            while(scanner.hasNextLine()){
                temp = scanner.nextLine();
                expenseLists.get(temp.length()).add(Integer.parseInt(temp));
            }
            for(int i = 0; i < 5; i++){
                Collections.sort(expenseLists.get(i));
            }
            int i = 0;
            while(i < expenseLists.get(4).size() && expenseLists.get(4).get(i) < 1010){
                expenseLists.get(3).add(expenseLists.get(4).get(i));
                i++;
            }
            int a = 1;
            int j = expenseLists.get(4).size() - 1;
            while(a < 4 && j > i){
                for(int k = 0; k < expenseLists.get(a).size(); k++){
                    if(expenseLists.get(a).get(k) + expenseLists.get(4).get(j) >= 2020){
                        if(expenseLists.get(a).get(k) + expenseLists.get(4).get(j) > 2020){
                            k--;
                            j--;
                        } else{
                            System.out.println(expenseLists.get(a).get(k));
                            System.out.println(expenseLists.get(4).get(j));
                            System.out.println(expenseLists.get(a).get(k)*expenseLists.get(4).get(j));
                        }
                    }
                }
                a++;
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        System.out.println(1010*1010);
    }
}
