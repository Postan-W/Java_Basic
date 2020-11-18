import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.System.*;
import static java.lang.System.*;
//可以直接将import static java.lang.System.out;
public class Main<T extends Comparable> implements GenericInterface<T>, Serializable {
    //序列化标识，如果一个对象的序列化文件被反序列化时跟申明的类中的ID不一样，则不能被反序列化
    private static final long serialVersionUID = 1L;
    private T data;

    @Override
    public T genericInterfaceData(){
        return data;
    }
    //带有限定的泛型方法

    private static <T extends Comparable> T genericMethod(T data){
        return data;
    }


    public void setData(T data){
        this.data = data;
    }

    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
       // String welcome = in.nextLine();
       // System.out.println(welcome);
        //泛型类测试
        Main<String> stringGeneric = new Main<>();
        stringGeneric.setData("泛型类，字符串类型");
        out.println(stringGeneric.genericInterfaceData());

        //泛型接口测试
        ImplementGenericInterfaceOfString<Integer> genericInterfaceOfString = new ImplementGenericInterfaceOfString<>(100);
        out.println(genericInterfaceOfString.genericInterfaceData());
        List<ImplementGenericInterfaceOfString> childs = new ArrayList<>();
        childs.add(genericInterfaceOfString);
        //泛型方法测试
        out.println(Main.<ImplementGenericInterfaceOfString>genericMethod(genericInterfaceOfString));
        //对象的序列化
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("main.txt"));
            output.writeObject(stringGeneric);
            output.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //对象的反序列化
        try{
            ObjectInputStream input =new ObjectInputStream(new FileInputStream("main.txt"));
            Main<String> serialMain = (Main)input.readObject();
            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //日志测试
        Logger.getGlobal().info("global log information");
        Logger.getGlobal().setLevel(Level.ALL);
        //条件表达式测试
        int number = 20;
        if (number > 30){
            out.println(number);
        }
        else{
            out.println(number+1);
        }
        //数组测试
        int[] a = new int[3];
        int[] b = {1,2,3,4};
        int[] c = new int[]{5,6,7,8};
        //for each测试
        for(int element:a){
            out.println(element);
        }
    }
    //静态代码块测试
    static {
        System.out.println("静态初始化块在类初次加载时执行");
    }
    //普通代码块测试
    {
        out.println("非静态初始化块在new对象时调用");

    }
}
