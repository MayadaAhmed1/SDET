package streamLambda;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testCaseNewStreamCollect {
    //Collect your result and convert it back to list by using collection
   //Print list of data which ends with letter "a" and convert this name to uppercase
@Test
    public void streamCollect(){

      List<String> ls=Stream.of("Mayada","Adam","Don","Alex","Aya").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
              .collect(Collectors.toList());
      System.out.println(ls);
    System.out.println(ls.get(0));
    }

//    Print unique numbers of list and then sort them
@Test
    public void streamCollect2(){

       List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
       List<Integer> ls=values.stream().distinct().sorted().collect(Collectors.toList());
       System.out.println(ls);
    }
}
