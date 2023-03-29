import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;
import java.util.stream.Stream;
//Stream API — это новый способ работать со структурами данных в функциональном стиле.
// Stream (поток) API (описание способов, которыми одна компьютерная программа может взаимодействовать с другой программой) — это по своей сути поток данных.
// Сам термин "поток" довольно размыт в программировании в целом и в Java в частности.
public class Main {
    public static void main(String[] args) {

       int []Array={50,60,70,80,90,110,120};
       int count=0;
       //Вывести 3 числа из массива меньше 90,с увеличением на 10 перед выводом
       for (int e:Array){
           if (e>=90) continue;
           e+=10;
           count++;
           if (count>3)break;
           else {
               System.out.printf("\n%d",e);
           }
       }
        System.out.println("\nStreamAPI:");
        IntStream.of(Array).filter(x->x<90).map(x->x+10).limit(3).
                forEach(System.out::println);

        List<String> list=new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");

        Stream stream=list.stream();
        stream.filter(x->x.toString().length()==3).forEach(System.out::println);
        System.out.println("\nВывод с форматированием");
        list.stream().forEach(x-> System.out.print(" "+x));

        System.out.println("\nСоздадим коллецию list5 из потока");
        List<String> list5=new ArrayList<String>();
        //list.stream().forEach(x->list5.add(x)); //В list5 добавляеются все элементы list(потока)

        list.stream().filter(x-> x.length()==3).forEach(x->list5.add(x));
        System.out.print(list5);
//-------------------------------------------------------------------------------

        //Пример 1. IntStream.range(0,x)
//        System.out.println("IntStream.range(0,x)");
//        Stream<Integer> stream2=Stream.of(1,2,3,4,5);
       // Stream.of(list).map(x->list.get(IntStream.range(1,3).sum())).forEach(System.out::println);
        //stream.limit(5).forEach(System.out::println);

        System.out.println("IntStream.range(0,x)");
        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::println);//перечень стримов(потоков);

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::print);// 010120012



        //limit(long maxSize) – ограничивает стрим по количеству элементов:
        System.out.printf("\nlimit(long maxSize) – ограничивает стрим по количеству элементов\n");
        stream = list.stream();
        stream.limit(2).forEach(x->System.out.print("\nВыводим элементы\n"+x));

        list.stream().limit(5).forEach(System.out::println);

//skip(long n) – пропускаем n элементов:
        System.out.printf("\nskip(long n) – пропускаем n элементов\n");
        list.stream().skip(3).forEach(x -> System.out.println(x));

//sorted(Comparator comparator) – сортирует стрим (сортировка как у TreeMap):
        System.out.printf("\nsorted\n");
        list.stream().sorted().forEach(x -> System.out.println(x));

        Test test=new Test();
        test.print();





    }
}