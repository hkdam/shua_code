package study;

public class Person {


    protected String type;

    public Person(){}

    public Person(String type){
        this.type = type;
    }

    protected void showtype(){
        System.out.println(this.type);
    }
}
