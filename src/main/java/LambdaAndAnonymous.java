import java.util.Comparator;
import java.util.Iterator;

public class LambdaAndAnonymous {
    Thread thread = new Thread(() -> System.out.println("Hello!"));

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello!");
        }
    });

    Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
    Comparator<String> comparator1 = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    };

    Iterator<Integer> iterator = new Iterator<Integer>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return 0;
        }
    };

}
