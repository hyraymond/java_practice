import java.util.*;

// solution one
// class Singleton{
//     private static Singleton instance = null;
//     private Singleton() {}
//     public static Singleton getInstance() {
//         if (instance == null)
//         {
//             instance = new Singleton();
//         }
//         return instance;
//     }
// }

// solution two
// class Singleton{
//     private static Singleton instance = null;
//     private Singleton() {}
//     public static synchronized Singleton getInstance() {
//         if (instance == null)
//         {
//             instance = new Singleton();
//         }
//         return instance;
//     }
// }

// solution three
// class Singleton{
//     private static Singleton instance = new Singleton();
//     private Singleton() {}
//     public static Singleton getInstance() {
//         return instance;
//     }
// }

// solution four
class Singleton{
    private static class local_singleton {
        private static final Singleton instance = new Singleton();
    }
    private Singleton() {}
    public static Singleton getInstance() {
        return local_singleton.instance;
    }
}

public class Single_Pattern {
    
    public static void main(String[] args)
    {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a == b);
        Object p = new Object();
    }
}
