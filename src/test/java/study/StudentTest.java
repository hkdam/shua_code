package study;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class StudentTest extends TestCase {

    @Test
    public void testReflect() throws Exception {

        // 获取类的字节码对象
        Class<?> clazz1 = Class.forName("study.Student");
        Class<?> clazz2 = Student.class;
        Class<?> clazz3 = new Student().getClass();


        Object o = clazz1.newInstance();
        System.out.println(o);

        Field filed = clazz1.getDeclaredField("age");
        // 可以访问私有
        filed.setAccessible(true);
        filed.set(o, 1000);
        System.out.println(o);

        Method method = clazz1.getMethod("showLocation", String.class);
        method.invoke(o, "hangzhou");


        showClassInfo(clazz1);
//        showClassInfo(clazz2);
//        showClassInfo(clazz3);

        getFields(clazz1);

        getMethods(clazz1);

        getCons(clazz1);

        createInstanceByClass(clazz1);


    }

    public void showClassInfo(Class<?> clazz){

        //打印的是Student类对应的字节码对象
        System.out.println(clazz);
        //获取Student类对应的字节码对象clazz的名字
        System.out.println(clazz.getName());
        //通过Student类对应的字节码对象，获取Student类的类名
        System.out.println(clazz.getSimpleName());
        //通过Student类对应的字节码对象，获取Student类对应的包对象
        System.out.println(clazz.getPackage());
        //通过Student类对应的字节码对象，先获取Student类对应的包对象，再获取这个包对象的名字
        System.out.println(clazz.getPackage().getName());

        /**
         * 结果：
         *
         * class study.Student
         * study.Student
         * Student
         * package study
         * study
         */
    }


    /**
     * 获取成员变量
     */
    public void getFields(Class<?> clazz) throws NoSuchFieldException {
//        Field getFid=cl.getDeclaredField("school");
//        getFid.set(obj,"华润希望小学");
//        getFid.get(obj)

        System.out.println("---------------- getFields");
        // 只能获取public name , class java.lang.String
        // 包括继承过来的public
//        Field[] fields = clazz.getFields();

        // 所有属性
        Field[] fields = clazz.getDeclaredFields();


        for(Field fs: fields){
            System.out.println(fs.getName() + " , " + fs.getType());
        }
    }

    /**
     * 获取成员方法，
     */
    public void getMethods(Class<?> clazz){

        // 只能获取public,包括继承过来的pulic
        System.out.println("----------------- getMethods");
        Method[] methods = clazz.getMethods();
        for(Method mt : methods){
            System.out.println(mt);
            System.out.println(mt.getName());
            Class<?>[] pt = mt.getParameterTypes();
            System.out.println(Arrays.toString(pt));
        }
    }


    public void getCons(Class<?> clazz){

        System.out.println("--------------- getCons");
        Constructor<?>[] cons = clazz.getConstructors();
        for(Constructor con : cons){
            System.out.println(con.getName());
            Class[] pt = con.getParameterTypes();
            System.out.println(Arrays.toString(pt));
        }
    }

    public void createInstanceByClass(Class<?> clazz) throws Exception {

        System.out.println("------------ createInstanceByClass");
        Object o = clazz.newInstance();
        System.out.println(o);

        // 获取指定构造
        Constructor<?> c = clazz.getConstructor(int.class, String.class);
        Object o2 = c.newInstance(10, "dhk");
        System.out.println(o2);
    }
}