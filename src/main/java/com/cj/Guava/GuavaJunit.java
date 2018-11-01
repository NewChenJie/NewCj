package com.cj.Guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import lombok.SneakyThrows;
import org.junit.Test;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GuavaJunit {
    /**
     * 新集合类型可以多次添加相等的元素
     * 允许重复，但是不保证顺序
     * Multiset有一个有用的功能，就是跟踪每种对象的数量，所以你可以用来进行数字统计
     */
    @Test
    public void multiSetTest(){
        /**
         * 　　   add(E element) :向其中添加单个元素
         *　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
         *　　　　count(Object element) : 返回给定参数元素的个数
         *　　　　remove(E element) : 移除一个元素，其count值 会响应减少
         *　　　　remove(E element,int occurrences): 移除相应个数的元素
         *　　　　elementSet() : 将不同的元素放入一个Set中
         *　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
         *　　　　setCount(E element ,int count): 设定某一个元素的重复次数
         *　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数
         *　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素
         *　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
         */
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        Collections.addAll(wordList, words);
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
        }

    @Test
    public void multiMapTest(){
        Multimap<String,String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");
        // Getting the size
        int size = myMultimap.size();
        // 5
        System.out.println(size);
        // Getting values
        Collection<String> fruits = myMultimap.get("Fruits");
        //  [Bannana, Apple, Pear, Pear]
        System.out.println(fruits);
        // [Bannana, Apple, Pear]
        System.out.println(ImmutableSet.copyOf(fruits));
        // Set<Foo> set = Sets.newHashSet(list);
        // Set<Foo> foo = new HashSet<Foo>(myList);
        Collection<String> vegetables = myMultimap.get("Vegetables");
        // [Carrot]
        System.out.println(vegetables);

    }
    @Test
    public void testApi(){
        //拆分器
        String s="1,2,2,3,, ,";
        ArrayList<String> strings = Lists.newArrayList(Splitter.on(',').trimResults().omitEmptyStrings().split(s));
        System.out.println(strings);
        //连接器
        String s1 = Joiner.on(",").join(Lists.newArrayList("a","b","c"));
        System.out.println(s1);
        //字符匹配器
        String S2 = CharMatcher.JAVA_DIGIT.removeFrom("DFSD654ERASDF");
        System.out.println(S2);
    }

    @Test
    @SneakyThrows
    public void testStream(){
//        String s = Files.toString(new File("D:\\1.txt"), Charsets.UTF_8);
//        System.out.println(s);
        boolean b = LocalDate.now().isBefore(LocalDate.now().plusDays(1));
        System.out.println(LocalDate.now().getMonth().getValue());
        System.out.println(b);
        System.out.println(MonthDay.from(LocalDate.now()));
        System.out.println(MonthDay.now());
        System.out.println(MonthDay.parse("--08-11"));
    }

}
