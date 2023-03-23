package study;

public class Student extends Person{

    private int age;

    public String name;

    public Student(){
        this.age = 1;
        this.name = "d";
    }

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }


    public void showLocation(String location){

        System.out.println(String.format("name: %s age: %d, loc: %s", this.name, this.age, location));
    }

    protected void eatFood(String food){
        System.out.println(String.format("name: %s age: %d, is eating: %s", this.name, this.age, food));

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
