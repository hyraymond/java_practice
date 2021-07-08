# JAVA学习笔记
---
## 2020/01/08
1. 指针和引用的区别
   1. 指针是实体，引用是别名
   2. 引用定义初始化一次
   3. 引用没有顶层const
   4. sizeof指针是指针大小，引用是对象大小
2. 计算机存储数据：
   1. 寄存器：数量极其有限，速度也快，与32/64位操作系统有关
   2. 堆栈：位于RAM中，对象引用储存于此
   3. 堆：动态分配的存储空间，对象往往存储于此
   4. 常量存储
   5. 非RAM存储：完全存活于程序之外，比如文件系统
3. 与C/C++的区别之一：
   * 基本类型的大小通用，不随处理器位数而改变。
   * byte类型
   * char类型占两个字节
   * 包装器类将其它类型转换为目标类型，便于传值，方便转化
4. 类包含的内容：
   * 字段，AKA数据成员
   * 方法，AKA成员函数
5. 类的基本数据类型字段会被默认初始化，获得一个默认值。而局部变量并不会。

---
## 2020/01/09
1. Random的用法：
   * import java.util.Random
   * Random rod = new Random([seed])
   * rod.nextInt(x) //生成[0,x)的整数
2. 一般引入import和静态引入import static，区别在于一般引入后还需要通过类名的方式访问对应的方法，而静态引入后直接调用即可，优点在于方便，缺点在于可能会引起歧义，降低代码的可读性。总之，小程序引用方便，大程序尽量不要这么做。
3. 通过标签和循环中断语句来替代goto
```JAVA
lable1:
outer loop
	inner loop
		break lable1 //同时中断两层循环到lable1处，但是不再进入循环
		continue lable1 //同时中断两层循环到lable1处，但是继续进入循环
```
4. 成员变量赋值是优先于构造器初始化的，如果作者没有赋值，则编译器自动赋予空值。
5. 执行顺序:
执行父类静态代码,执行子类静态代码
初始化父类成员变量（我们常说的赋值语句）
初始化父类构造函数
初始化子类成员变量
初始化子类构造函数
6. 甚至可以通过参数列表的顺序来区分重载方法，但是却不能通过返回值来做。
7. JAVA向上转换隐式，编译器会自动做，而向下转换必须是显示的，隐式的向下转换会报错。
8. static方法的默认传参没有this引用，所以static方法的内部不能调用非静态方法，反之却可以。
9. System.gc()强制触发垃圾回收动作，前提是没有对该对象的引用。
10. 垃圾回收思想：
   * 停止复制（stop and copy）。这种方法的问题第一在于需要更大的内存，第二在稳定且产生的垃圾不多时，会带来过多不必要的开销。
   * 标记清扫（mark and sweep）。
11. 局部变量未初始化就使用会触发编译错误。
12. 在类的内部，变量定义的先后书写顺序决定了初始化的顺序。
13. 枚举类的实现
```java
enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

Day day = Day.FRIDAY; //使用方式，有点类似于类访问
```
14. JAVA的默认打印行为（toString）就是打印“类的名字@对象的地址”。
15. JAVA实现可变参数的语法，通过将参数设定未Object的数组。
16. 实际上在使用关键字enum创建枚举类型并编译后，编译器会为我们生成一个相关的类，这个类继承了Java API中的java.lang.Enum类，也就是说通过关键字enum创建枚举类型在编译后事实上也是一个类类型而且该类继承自java.lang.Enum类。
17. 访问权限的控制等级，从大到小依次是：public，protected，包访问权限（没有关键词）和private。包内包含有一组类，它们在单一的名字空间之下被组织在了一起。
18. 每个后缀名.java的文件称为一个编译单元/AKA转译单元，每个编译单元只能有一个public类，否则编译器会报错。其中如果使用package语句，必须是文件中除了注释以外的第一句程序代码，写于文章起始处，如package aceess; 在组织工程的过程中，每个包/AKA package语句都代表当前工作目录下的子目录，且当前工程任何文件调用都是同样的，没有路径差异。
19. 同一个文件夹路径下的java文件，都会默认当前文件的包单元，但是如果一个文件手动声明了，那么只有有相同声明的类才能访问它的成员。

---
## 2020/01/10
1. 一般写一个类的习惯是将public成员置于开头，后面跟protected，包访问权限，最后private成员。
2. 类的访问权限限制：
   1. 每个编译单元（文件）都只能有一个public类。
   2. public类的名称必须完全和含有该编译单元的文件名相匹配，包括大小写。
   3. 编译单元可以完全不带public类。
3. 静态方法不能调用非静态方法，因为没有this指针。
4. 每个类都应该有一个“public String toString()"方法（不能是静态方法），在打印时会自动调用，否则就会打印出 类名@地址 的部分。
5. 继承语法 "class circle extends shape { }"
6. 子类会自动获得父类的所有域（成员）和方法（函数），在未重载时还保持一样。且子类会自动调用父类的构造函数（python就不一样了，不会自动调用的，需要显示手动）。
7. @override 注释可以声明该方法是覆盖而不是重载，编译器会帮忙检查的。
8. final关键词：
   1. final数据，对于基本数据类型，值不可变；对于对象，则表示引用对象不可变，是一个顶层const。
   2. final参数，意味着在方法内部无法改变引用的对象。
   3. final方法，一方面将方法锁定，防止任何继承类修改它的含义。另一方面会转为内联函数，提高效率（少这样考虑）。
   4. final类，表示该类不可继承。
9. 类中的所有private方法都被隐式的声明为final，当然可以再手动添加，但是不会有任何效果。
10. private方法似乎是可以覆盖的，但是实际上是生成了一种同名方法而已，原有private方法依然是untouchable。

---
## 2020/01/11
1. JAVA中除了static方法和final方法（private方法是自动final的），其它方法都是后期绑定的。
2. 构造器并不具有多态性（实际上是static方法，只不过static声明是隐式的）。
3. 在构造器被调用时，只能保证父类的构造器已经被调用过了，而一些动态绑定的方法可能处于未知的状态，其后果难以预料。
4. ![container](container.png)
5. 对于向上转型，在C++中需要使用dynamic_cast去确保操作的安全，而在JAVA中，直接加括号转换就可以了，JAVA会对所有类型转换进行称为”运行时类型识别（RTTI）“的操作。
6. API中几个常用方法：
   * size() ：返回值为int,返回此 set 中的元素的数量（set 的容量）。
   * isEmpty():返回值为boolean, 如果此 set 不包含任何元素，则返回 true。
   * add(E e):返回值为boolean,如果此 set 中尚未包含指定元素，则添加指定元素。
   * iterator():返回值为Iterator<E>, 返回对此 set 中元素进行迭代的迭代器。
   *  remove(Object o):返回值为boolean,如果指定元素存在于此 set 中，则将其移除。
   *  contains(Object o):返回值为boolean,如果此 set 包含指定元素，则返回 true。
   *  clear():无返回值, 从此 set 中移除所有元素。
   *  addAll(set): 深拷贝，不影响
   *  indexOf(E e): 通过对象的引用返回index，不存在则返回-1

7. abstract关键字，表示一个抽象类或者一个抽象方法，当类中含有抽象方法时，必须标识这是一个抽象类。**抽象类无法进行实例化**，子类继承抽象类后必须把它的抽象方法均实例化后才不会报错，覆盖的过程中，加不加@Override都是一样的。当然，**抽象类也可以没有抽象方法，但是，依然不能实例化**。
8. 抽象方法必须为public或者protected，因为private类没有办法对重写，缺省状态下是public。
9. 抽象类的其它部分是和普通类无差别的，会继承域/方法，也可以改写。

10. interface关键字（对应implements），代表着更加抽象的一种类，接口类，接口类的所有方法都默认是抽象方法，域都是默认的static+final+public。

11. 一个子类只能继承一个基类，但是可以组合多个接口。且继承的基类必须前置，否则编译器报错，代码如下：
```JAVA
interface CanFight{
	void fight();
}
interface CanSwim{
	void swim();	
}
class ActionCharacter{
	public void fight() {};
}
class Hero extends ActionCharacter
	implements CanFight, CanSwim{
		public void swim(){}
	}
```
12. 多个接口类的组合情况下，允许同名的方法。当两方法可以区分时，则视为重载；完全相同时，则视为一个方法；当不完全相同又不足以区分时，则报错。而对于域来说，只要不使用就没问题，使用则报错，ambiguous。
13. 在enum关键字出现以前，使用public interface接口类的域来起到和枚举相同的效果。
14. **内部类与组合的机制是完全不同的概念** 内部类的引用创建为OuterClassName.InnerClassName = new OuterClassExample.InnerClassConstructor()
除此之外，内部类的使用和普通类没有什么不同。

---
## 2020/01/12
1. C++的嵌套类的设计只是单纯的名字隐藏机制，与外围对象没有联系，也没有隐含的访问权。而对于JAVA，生成一个内部类的对象时，能访问其外围对象与包含的所有元素，而不需要额外的特殊条件。反过来，外部类也对内部类有着完全的访问权限。
2. 内部类会被编译器自动传入一个外围类的引用，以此获得对于外围类的完全访问权限。
3. 对于接口类，只能使用implements关键字进行部署，而不能使用关键字extends进行继承。
4. 使用外部类名字后面紧跟圆点和this，以此生成对外部类对象的引用。使用外部对象.new 内部类构造函数的方法创建内部类的对象（在类外部时这样）。
5. 使用private内部类，实现公共的接口，然后外部类通过函数返回内部类，再向上转型成接口类，可以完全隐藏具体的实现细节。
6. 在方法的作用域内（而不是在其它类的作用域内）创建一个完整的类，称为局部内部类。示例代码如下：PDestination是destination方法的一部分，而不是Parcel5的一部分，所有局部内部类不能访问外部类，反过来也不行。而且可以在外部类的任意字幕侠使用标识符PDestination，而不会有命名冲突。
```java
public class Parcels {
	public Destination destination(String s) {
		class PDestination implements Destination {
			private String lable;
			private PDestination(String whereTo) {
				label = whereTo;
			}
			public String readLabel() { return label; }
		}
		return new PDestination(s);
	}
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
	}
}
```
7. 在某作用域定义的局部内部类，表示该类只在这个作用域内有效，其余和普通类没有差别。
8. 匿名内部类，如下代码表示创建一个继承自Contents的匿名类的对象，通过new表达式返回，然后自动向上转型为对Contents的引用。代码如下：
```java
public class Parcel7b {
	public Contents contents() {
		return new Contents () {
			private int i = 11;
			public int value() { return i; }
		};
	}
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
}
```
9. ==数组长度通过length获取，字符串长度通过length()获取==
10. JAVA的args和C/C++不同，从0开始就是输入的字符串。
11. 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会需要其引用的参数是final的。
12. 匿名类因为没有名字，没有办法实现构造器，但是可以添加一个内部方法手动调用，实现类似的效果。
13. 因为内部类需要自动传入一个外部类的引用，所以要实例化内部类，必须要有一个外围类的对象。
14. 嵌套类：将内部类声明为static，则不会保留一个只想外部类的引用。则创建嵌套类不需要外围类的对象；也不能够从嵌套类的**对象**中访问非静态的外围类对象（但是其实静态也行）。
15. **继承会将普通域/普通方法/静态域/静态方法通通继承，没有区别。包括内部类，而且允许override。**
16. 非静态方法访问静态方法和静态变量都没有问题，而反过来，静态方法访问非静态变量和非静态方法均不行，因为没有隐式的this指针支持。
17. **因为内部类在逻辑上相当于外部类的一个成员，它的示例初始化依赖于外围类的对象，所以普通内部类是不能拥有static的域或者方法的**
18. 嵌套类因为不依赖于外围类的对象，所以是可以拥有static数据和static方法的。
19. 因为接口类的所有成员默认都是static和public的，所以接口类不能有普通内部类，但是可以有嵌套类。
20. **为什么需要内部类：**每个内部类都能独立的继承一个类/接口，而无论外部类是否继承，都对内部类没有影响。从某种程度上说，内部类实现了一种多重继承。

---
## 2020/01/13
1. 闭包(closure) 和 回调(callback)：闭包是一种能被调用的对象，它保存了创建它的作用域的信息。回调即允许客户类通过内部类引用来调用其外部类的方法。JAVA没有显式的支持闭包，但是它的内部非静态类就是隐式的一种闭包实现。
2. 内部类的好处：
   1. 实现多重继承
   2. 内部类可以很好的实现隐藏，一般的非内部类，是不允许有private和protected权限的，但内部类可以
   3. 减少了类文件编译后的产生字节码文件大小
3. 不管时成员内部类，静态内部类，局部内部类还是匿名内部类，编译之后均会生成单独的class文件，外部类@内部类.class的格式，对于匿名内部类，外部类@1.class的形式。示例代码如下：
-rw-r--r-- 1 87335 197609  571 Jan 13 21:05 'cat$1.class'
-rw-r--r-- 1 87335 197609  525 Jan 13 21:05 'cat$1minicat.class'
-rw-r--r-- 1 87335 197609  256 Jan 13 21:05 'cat$claw.class'
-rw-r--r-- 1 87335 197609  307 Jan 13 21:05 'cat$tail.class'
4. 不能用访问控制符修饰修饰局部内部类：因为该内部类的生存周期只是这个方法，外部是不能访问的，当然也就不需要访问控制修饰符来控制。
5. 不能用static修饰符来修饰局部内部类：static会单独包有一块内存空间，这样就违反了局部的原则，而实际上变成了一个全局的变量。
6. 静态内部类（嵌套类）可以访问外部类的静态成员，但是因为没有自动持有外围类对象的引用，所以要想访问非静态成员，需要手动持有外围类的对象。

---
## 2020/01/17
1. 学习了String，StringBuffer和StringBuilder，因为String是字符串常量，即不可变字符串，因此在效率上最慢。另外两个都是可变字符串，在效率上更快，用append进行添加。而StringBuffer确保线程安全，因此慢一点，StringBuilder不确保现场安全，效率更高。效率对比如图所示：
![](stringbufferbuilder.png)

---
## 2020/01/18
1. JAVA所有的基本变量都是有符号数
2. 表示JAVA的最大/最小整数，Integer.MAX_INT/Integer.MIN_INT
3. JAVA Math类常用方法总结：
   1. Math.sqrt(x) //平方根
   2. Math.cbrt(x) //立方根
   3. Math.pow(x, y) //x的y次方
   4. Math.exp(x) //e的x次方
   5. Math.max
   6. Math.min
   7. Math.abs(x)
   8. Math.ceil(x) //进一
   9. Math.floor(x) //舍一
   10. Math.round(x) //四舍五入
   11. Math.random() //产生0到1之间的数
   12. Math.toDegree(x) //转换为角度
   13. Math.toRadians(x) //转换为弧度
   14. import java.lang.Math //引入Math类
4. ***一道非常值得思考的题目，Leetcode第8题：***
* 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0 。
* 可以看到，题目要求是比较复杂的，有很多林林总总的不同状态下的不同规则，这个时候可以考虑使用有限状态机的思想。有限状态表用Map的形式表示。部分示例代码如下：
```JAVA
private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
```
5. 任何对象/类被打印时，会调用String toString函数，打印出结果。
6. Arrays的常用接口：
   * import java.lang.Arrays //引入数组
   * Arrays.asList([]) //将数组转换成List
   * Arrays.binarySearch([], key) //用二分查找key
   * Arrays.copyOfRange([], start, end) //复制含头不含尾巴的数组
   * Arrays.equals(A[], B[]) //判断AB两个数组是否相等
   * Arrays.fill([], key) //用key填满这个数组
   * Arrrays.sort([], comparator) //给出比较器进行排序
   * Arrays.toString([]) //打印操作
7. 插入排序伪代码：
```pseudocode
pseudocode: insertionSort(A, start, end)
for i = start to end do
    key = A[i]
    j = i - 1
    while j > start - 1 and A[j] > key do
        A[j + 1] = A[j]
        j = j - 1
    end while
    A[j + 1] = key
end for
```
8. 归并排序伪代码
```pseudocode
pseudocode: mergeSort(A, start, end)
if (start == end)
    return;
mid = ⌊(start + end) / 2⌋
mergeSort(A, start, mid)
mergeSort(A, mid + 1, end)
merge(A, start, end, mid)

pseudocode: merge(A, start, end, mid)
L = A[left, mid]
R = A[mid + 1, right]
Maintain two pointers pl pr, initialized to point to the
first elements of L, R, respectively
while both lists are non empty do
    Let x, y be the elements pointed to by pl, pr
    Compare x, y and append the smaller to the ouput
    Advance the pointer in the list with the smaller of x, y
end while
Append the reaminder of the non-empty list to the output.
```
9. 冒泡排序伪代码（优化，当某一次起泡未进行交换时，提前退出）
```pseudocode
pseudocode: optimizeBubbleSort(A, start, end)
bool change_sig = false
for i = start to end  do
    change_sig = false
    for j = end downto i + 1 do
        if A[j] < A[j - 1] do
            swap(A[j], A[j - 1])
            change_sig = true
        end if
    end for
    if true == change_sig do
        break
    end if
end for
```
10. 选择排序伪代码
```pseudocode
pseudocode: selectSort(A, start, end)
for i = start to end -1 do
	for j = i + 1 to end do
		if A[i] > A[j] do
			swap(A[i], A[j])
		end if
	end for
end for
```
11. 快速排序伪代码
```pseudocode
pseudocode: quickSort(A, start, end)
key = A[start]
i = start
j = end
if start >= end do
	return 
end if
while i < j do
	while i < j and A[j] >= key do
		j--
	end while
	swap(A[i], A[j])
	while i < j and A[i] < key do 
		i++
	end while
	swap(A[i], A[j])
end while
	A[i] = key
quickSort(A, start, i - 1)
quickSort(A, i + 1, end)
```
12. 各个排序算法的时间效率比较发现，Arrays自带排序  > 归并排序 > 快速排序 > 直接插入排序 > 选择排序 > 优化的冒泡排序 > 冒泡排序，运行结果如下：
![](sort.png)
13. 每一个编译过后的.class，都会生成一个Class对象，这个对象保存着这个类的一切信息，在编译后储存在程序代码段，.class文件中。当需要被加载时，往往是对象或者引用被创建时动态加载。

---
## 2020/01/19
1. List的常用接口：
   1. add(int index, E element) //插入元素到指定位置，后面的元素都向后移一步
   2. addAll(int index, Collection<> c) //从index的位置开始将所有Collection插入
   3. get(int index) //返回指定索引位置的元素
   4. int indexOf(E element) //返回第一次出现该元素的索引位置，如果没有，则返回-1
   5. ListIterator<E> listIterator(int index) //返回列表指定索引位置元素的迭代器
   6. remove(int index) //删除指定索引的对象
   7. set(int index, E element) //更改index位置元素为element
   8. subList(int fromIndex, int toIndex) //返回从索引fromIndex到toIndex的元素集合，包左不包右
2. Map的常用接口：
   1. put(key, value) //添加键值对
   2. clear() 清空map
   3. boolean containsKey(key) 判断是否包含某个key
   4. boolean containsValue(value) 判断map中是否包含某个value
   5. get(key) 通过key获取value
   6. isEmpty() 判断是否为空
   7. Set keySet() 获取map集合所有的key
   8. remove(key) 通过key删除键值对
   9. size() 获取map中的个数
   10. Collections values() 获取map集合所有的value
3. **双大括号初始化的理解和使用**：所谓双大括号初始化，是利用了匿名内部类的构造器语法，需要注意的是，**匿名内部类的构造器可以有多个，且会自动调用父类的构造器（普通子类也会默认调用父类的构造方法**。示例代码如下：
```java
class person {
    person() {
        System.out.println("this is person");
    }
}
public class tes {
    public static void main (String[] args) {
        // Solution.main(args);
        person Jack = new person() { 
            {System.out.println("this is anomynous person");} 
            {System.out.println("this is another anomynous person");}
        };
    }
}
```
4. 因此可以使用匿名内部类的构造方法来初始化一些容器，特别是set和map。代码示例如下：
```java
private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
```
5. ==**容器只能用包装器类而不能用基本类型**==
6. 迭代器：**统一了对容器的访问**。迭代器只能用来：
   1. 通过iterator()方法返回一个迭代器
   2. 使用next()获取序列的下一个元素
   3. 使用hasNext()检查序列是否还有元素
   4. 使用remove()将迭代器新进返回的元素删除

---
## 2020/01/20
1. Map没有迭代器
2. Map同样只接受以Object对象为泛型参数，也就是说，不支持基本类型。
3. 容器通过add/put添加容器成员时，其实是添加进了各个元素的引用。实验如下，当容器内容是String这样的不可变成员时，外部的改变同样是引用的改变，而没有更改原来对象，所以容器中储存的信息似乎没有被更改。但是当成员是StringBuilder这样的可变成员时，更改外部的对象，导致了容器储存信息的改变。代码如下:
```java
List<String> top = new ArrayList<String>();
String b = "pis";
top.add(b);
System.out.println(b);
System.out.println(top);
b = "mos";
System.out.println(b);
System.out.println(top);

List<StringBuilder> pop = new ArrayList<StringBuilder>();
StringBuilder c = new StringBuilder("hello");
pop.add(c);
System.out.println(c);
System.out.println(pop);
c.append("hi");
System.out.println(c);
System.out.println(pop);
```
实验结果如下:
```
pis
[pis]
mos
[pis]
hello
[hello]
hellohi
[hellohi]
```

---
## 2020/01/20
1. 归并排序伪代码
```pseudocode
pseudocode: mergeSort(A, start, end)
if (start == end)
    return;
mid = ⌊(start + end) / 2⌋
mergeSort(A, start, mid)
mergeSort(A, mid + 1, end)
merge(A, start, end, mid)

pseudocode: merge(A, start, end, mid)
pl = start
pr = mid + 1
index = 1
result_list[A.length]
while pl <= mid and pr <= end do
   if (A[pl] < A[pr]) do 
   {
      result_list[index++] = nums[pl++]
   }
   else do
   {
      result_list[index++] = nums[pr++]
   }
   end if
end while
if pl > mid
{
   while pr <= end  do
   {
      result_list[index++] = nums[pr++]
   }
   end while
}
else
{
   while pl <= mid dow
   {
     result_list[index++] = nums[pl++] 
   }
   end while
}
end if
for i = 1 to index - 1 do
   nums[index] = result[start + index]
end for
```
---
## 2020/01/24
1. 工厂方法：不通过new，而是通过一个静态方法来对外提供自身实例的方法，即为我们所说的工厂静态方法。
2. 工厂静态方法的好处：
   1. 与构造器不同，可以通过命名来提高可读性
   2. 不用每次调用时都创建新对象
   3. 可以返回原返回类型的子类型
3. 目前学到了两种初始化容器的方法：
   1. 使用匿名类的构造函数的方法，来创建，示例代码如下：
```
Map<Character, String> tes = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
```
   2. 使用Map内置的工厂函数，示例代码如下：
```
Map<Character, String> pos = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs",
                                            '8', "tuv", '9', "wxyz");
```
4. 比较了两种方式，发现还是工程函数更快，因为第一种在原理上，是通过在构造函数中不断调用put/add来实现的，第二种目前未知。
5. 