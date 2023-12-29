package streamLambda;

import org.apache.poi.ss.formula.functions.Count;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class testCaseNewStream {
    //Target to count number of names in the array that starts with letter "A" using stream
    //Steps: Create array list then use stream to replace for loop and if condition in one line
    //convert arraylist to stream then use filter method with lambda expression (parameters /action of lambda expression)
    //then apply method count to count final reuslt

@Test
    public void streamFilters(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

      Long c=names.stream().filter(s->s.startsWith("A")).count();
      System.out.println(c);
    }
//target : to print names that start with letter "A" using stream
@Test
    public void streamPrint(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

        names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
    }

    //target : to print first name that start with letter "A" using stream
    @Test
    public void streamLimit(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

        names.stream().filter(s->s.startsWith("A")).limit(1).forEach(s->System.out.println(s));
    }
}
