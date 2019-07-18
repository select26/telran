package dto;
 
public class Person {
     
    public String name;
    private String hobby;
     
    public Person() {}
    private Person(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }
     
    public static void foo(int n) {
        System.out.println("foo"+n);
    }
     
    public String getName() {
        return name;
    }
    private void setName(String first_name, String last_name) {
        this.name = first_name + " "+last_name;
    }
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", hobby=" + hobby + "]";
    }
     
     
 
}