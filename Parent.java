import java.util.regex.Pattern;

import static java.lang.System.*;
public class Parent {
    public int number;
    public String parentDescription ;
    Parent(int d){
        this.number = d;
    }
}
class Son1 extends Parent{
    public String son1Description;
    Son1(String des){
        super(1000);
        this.son1Description = des;
    }
}
class Son2{
    public String son2Description;
    Son2(String des){
        this.son2Description = des;
    }
}
class Generic<T>{
    public T data1;
    public String genericDescription;
    Generic(String des,T data){
        this.genericDescription = des;
        this.data1 = data;
    }
    public T data2;
}
