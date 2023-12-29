package streamLambda;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class testCaseOld {
    //Target to count number of names in the array that starts with letter "A"
    //steps: create arraylist then add values
    //create for loop with if condition to count names that start with letter "A"
    @Test
    public void names(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");
        int count =0;

        for(int i=0;i<names.size();i++) {
            String actual = names.get(i);
            if(actual.startsWith("A"))
            {
                count++;
            }
        }
        System.out.println(count);
    }

}
