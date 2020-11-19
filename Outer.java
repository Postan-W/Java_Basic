public class Outer extends One {

    /*使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个
        （接口的）实现，对于内部类都没有影响*/
    /*内部类拥有类的基本特征。(eg：可以继承父类，实现接口。)在实际问题中我们会遇到一些接口无法解决或难以解决的问题，
    此时我们可以使用内部类继承某个具体的或抽象的类，间接解决类无法多继承引起的一系列问题。（注：内部类可以嵌套内部类，
    但是这极大的破坏了代码的结构，这里不推荐使用。）
    *
    * */
    private int outerVariable = 1;
    private int commonVariable = 2;
    private static int outerStaticVariable = 3;
    public void outerMethod() {
        System.out.println("我是外部类的outerMethod方法");
    }
    public static void outerStaticMethod() {
        System.out.println("我是外部类的outerStaticMethod静态方法");
    }
    public void outerShow() {
        Inner inner = new Inner();
        inner.innerShow();
    }
    public Inner getInnerObject(){
        return new Inner();
    }
    //非静态内部类,这个叫成员内部类
    class Inner<T>extends Two implements FunctionIterface<T>{

        private int commonVariable = 20;
        public void innerShow() {
            //当和外部类冲突时，直接引用属性名，是内部类的成员属性
            System.out.println("内部的commonVariable:" + commonVariable);
            //内部类访问外部属性
            System.out.println("outerVariable:" + outerVariable);
            //当和外部类属性名重叠时，可通过外部类名.this.属性名
            System.out.println("外部的commonVariable:" + Outer.this.commonVariable);
            System.out.println("outerStaticVariable:" + outerStaticVariable);
            //访问外部类的方法
            outerMethod();
            outerStaticMethod();
        }
        @Override
        public T getDescription(T data) {
            return data;
        }
    }
}
