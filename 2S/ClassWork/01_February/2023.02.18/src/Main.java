public class Main {
    public static void main(String[] args) {
        IntArrayCollection arr = new IntArrayCollection(10);

        arr.add(5);


        System.out.println(arr.contains(5));

        //-----
        if (arr.contains(5)) {
            System.out.println("Contains, add - works!");
        } else {
            System.out.println("Contains, add - error exception!");
        }

        if (arr.size() != 1) {
            System.out.println("arr.size() - works!");
        } else {
            System.out.println("arr.size() - errorexception!");
        }

        arr.remove(5);

        if (arr.contains(5)) {
            System.out.println("arr.remove(i) - error exception!");
        } else {
            System.out.println("arr.remove(i) - works!");
        }


        for (int i = 0; i < 100; i++) {
            arr.add(i);
            System.out.println(arr.size());
        }

        if (arr.size() >= 100 + 1) {
            System.out.println("private resize - works!");
        } else {
            System.out.println("private resize - error exception!");
        }
    }
}
