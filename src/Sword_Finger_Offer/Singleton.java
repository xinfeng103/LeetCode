package Sword_Finger_Offer;

// 2. 设计一个类，要求只能生成该类的一个实例，即单例模式

//单例模式(Singleton Pattern)：确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，
// 这个类称为单例类，它提供全局访问的方法。单例模式是一种对象创建型模式。

// 实现：将构造函数置为私有的，只能通过静态方法获取对象，对象只能创建一次，可以在类内
//直接先创建对象（饿汉模式），也可以用到的时候再创建（懒汉模式），这时候为了保证对象只被创建一次，需要加锁

// 饿汉模式，开始就先创建对象
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    //使用private访问控制符来让外界不能new该对象；只能调用静态方法来获取。
    //这样方可实现外界永远获得的是同一个Java对象。
    public static Singleton getInstance() {
        return singleton;
    }
}

// 懒汉模式，推迟到用的时候再创建对象
// 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自行实例化，
// 这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例
class Singleton2 {
    private static Singleton2 singleton = null;

    private Singleton2() {
    }

    // 加锁保证只创建一次对象
    public synchronized static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

// 上面的懒汉模式每次调用getInstance()时都需要进行线程锁定判断，在多线程高并发访问环境中，将会导致系统性能大大降低
// 事实上，我们无须对整个getInstance()方法进行锁定，只需对其中的代码“instance = new LazySingleton();”进行锁定即可
class Singleton3 {
    private static Singleton3 singleton = null;

    private Singleton3() {
    }

    // 加锁保证只创建一次对象
    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                singleton = new Singleton3();
            }
        }
        return singleton;
    }
}


/*
  上面的代码有可能创建多个对象，原因如下
  假如在某一瞬间线程A和线程B都在调用getInstance()方法，此时instance对象为null值，
  均能通过instance == null的判断。由于实现了synchronized加锁机制，线程A进入synchronized锁定的代码
  中执行实例创建代码，线程B处于排队等待状态，必须等待线程A执行完毕后才可以进入synchronized锁定代码。
  但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象，
  违背单例模式的设计思想，因此需要进行进一步改进，在synchronized中再进行一次(instance == null)判断，
  这种方式称为双重检查锁定(Double-Check Locking)。
 */
/*
如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
被volatile修饰的成员变量可以确保多个线程都能够正确处理，且该代码只能在JDK 1.5及以上版本中才能正确执行。
由于volatile关键字会屏蔽Java虚拟机所做的一些代码优化，可能会导致系统运行效率降低，
因此即使使用双重检查锁定来实现单例模式也不是一种完美的实现方式。
 */
class Singleton4 {
    private volatile static Singleton4 singleton = null;
    // 为了在线程A中创建对象，对后面的线程B可见，使用volatile关键字，保持内存与缓存的一致性

    private Singleton4() {
    }

    // 加锁保证只创建一次对象
    public static Singleton4 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}

/*
  饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控制烦琐，而且性能受影响。
  Initializationon Demand Holder (IoDH)可以结合二者的优点，在IoDH中，我们在单例类中增加一个
  静态(static)内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance()方法返回给外部使用
 */
class Singleton5 {
    private Singleton5() {
    }

    public static class Singleton_ {
        private final static Singleton5 instance = new Singleton5();
    }

    //使用private访问控制符来让外界不能new该对象；只能调用静态方法来获取。
    //这样方可实现外界永远获得的是同一个Java对象。
    public static Singleton5 getInstance() {
        return Singleton_.instance;
    }
}