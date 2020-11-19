public class InnerClass extends Son1 {
    InnerClass(String des) {
        super(des);
    }
    /*使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个
        （接口的）实现，对于内部类都没有影响*/
    /*内部类拥有类的基本特征。(eg：可以继承父类，实现接口。)在实际问题中我们会遇到一些接口无法解决或难以解决的问题，
    此时我们可以使用内部类继承某个具体的或抽象的类，间接解决类无法多继承引起的一系列问题。（注：内部类可以嵌套内部类，
    但是这极大的破坏了代码的结构，这里不推荐使用。）
    *
    * */
    class InTheClass<T>extends Son2 implements FunctionIterface<T>{

        InTheClass(String des) {
            super(des);
        }

        @Override
        public T getDescription(T data) {
            return data;
        }
    }
}
