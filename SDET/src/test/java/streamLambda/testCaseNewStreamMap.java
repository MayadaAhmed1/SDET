package streamLambda;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class testCaseNewStreamMap {
    //Target to do some manipulation on the stream data
   //Print data which ends with letter "a" and convert this name to uppercase
@Test
    public void streamMap(){

      Stream.of("Mayada","Adam","Don","Alex","Aya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }

//    Print data which starts with letter "A" then sort them and convert this name to uppercase
@Test
    public void streamMapSort(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

    names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }

   // target : to concatenate two lists then sort them
    @Test
    public void streamCon(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

        List<String> names2= Arrays.asList("Mohamed","Ahmed","Youssef","Younes");
        Stream<String> newStream = Stream.concat(names.stream(),names2.stream());
        newStream.sorted().forEach(s->System.out.println(s));
    }

    // target : to assert at the concatenated list if it matches with value"mayada"
    @Test
    public void streamAssert(){

        ArrayList<String> names= new ArrayList<String>();
        names.add("Mayada");
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Aya");

        List<String> names2= Arrays.asList("Mohamed","Ahmed","Youssef","Younes");
        Stream<String> newStream = Stream.concat(names.stream(),names2.stream());
        Boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("mayada"));
        Assert.assertTrue(flag);
        System.out.println(flag);
    }
}
