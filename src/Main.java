public class Main {
    public static void main(String[] args) {

        StringList stringList = new StringListImpl(10);
        stringList.add("1");
        stringList.add("2");
        stringList.add("4");
        stringList.add("5");
        System.out.println(stringList.toString());
        System.out.println();

        stringList.add(1, "2");
        System.out.println(stringList.toString());
        System.out.println();

        stringList.remove("5");
        System.out.println(stringList.toString());

    }
}