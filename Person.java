class Main {
    public static void main(String[] args) {
        var person = new Person("山田 太郎", 30, "東京都");
        System.out.println(person);
    }
}

public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name    = name;
        this.age     = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, address='%s'}", name, age, address);
    }
}
