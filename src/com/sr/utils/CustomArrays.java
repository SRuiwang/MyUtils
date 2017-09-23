package com.sr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义数组工具类
 *
 * @author shaorui
 */
public class CustomArrays {

    private CustomArrays() {
    }

    /**
     * 实现数组中元素的去重，若泛型参数为自定义对象，必须重写equals方法
     *
     * @param ts
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getSingelList(List<T> ts) {
        if (ts == null) {
            return null;
        }
        List<T> t = null;
        try {
            t = ts.getClass().newInstance();
            Iterator<T> iterator = ts.iterator();
            while (iterator.hasNext()) {
                T t2 = (T) iterator.next();
                if (!t.contains(t2)) {
                    t.add(t2);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");

        List<String> array = getSingelList(list);
        for (String string : array) {
            System.out.println(string);
        }

    }

}
