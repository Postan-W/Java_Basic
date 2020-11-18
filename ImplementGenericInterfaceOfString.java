class ImplementGenericInterfaceOfString<N> implements Comparable<ImplementGenericInterfaceOfString>,GenericInterface<String> {
    public N data;
    ImplementGenericInterfaceOfString(N data){
        this.data = data;
    }


    @Override
    public String genericInterfaceData(){
        return "第二种实现泛型接口的方法";
    }
    //toString式Java中默认的输出对象的字符串表示形式的函数，可重写
    @Override
    public String toString(){
        return "类名:ImplementGenericInterfaceOfString";
    }
    @Override
    public int compareTo(ImplementGenericInterfaceOfString o) {
        return 0;
    }
}
