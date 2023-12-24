package com.monster.test;

import com.monster.test.domain.Personal;
import com.monster.test.domain.User;
import org.apache.commons.lang.StringUtils;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * java8 集合的一些用法
 * */
public class TestList {

    public static void main(String[] args) {
//        filterTest();
//        map();
//        flatMap("方法参数注释测试");
        List<Integer> numList = Arrays.asList(10, 20, 18, 300, 30, 2);
        // 默认排序
        List<Integer> orderList = numList.stream().sorted().collect(Collectors.toList());
        // [2, 10, 18, 20, 30, 300]
        System.out.println(orderList);
        List<Integer> orderDescList = numList.stream().sorted((x, y) -> {
            // 实现降序
            return y.compareTo(x);
        }).collect(Collectors.toList());
        System.out.println(orderDescList);
        // 使用中文构造器排序
        List<String> chineseNames = Arrays.asList("张三","李四","王五","赵六","张哥","李哥","王哥");
        List<String> orderChineseNames = chineseNames.stream().sorted(Collator.getInstance(Locale.CHINESE))
                .collect(Collectors.toList());
        System.out.println(chineseNames);
        // [李哥, 李四, 王哥, 王五, 张哥, 张三, 赵六]
        System.out.println(orderChineseNames);
    }

    /**
     * flatMap()函数，类似于map()操作，但是flatMap操作可以将每个元素映射成一个Stream,然后把所有生成的Stream合并成一个新的Stream
     * @param param 这个参数用来测试方法注释的，没有其他用处
     */
    private static void flatMap(String param) {
        Personal personal1 = new Personal("张三", Arrays.asList("抽烟", "喝酒", "烫头"));
        Personal personal2 = new Personal("李斯", Arrays.asList("编码", "喝酒", "踢足球"));
        List<Personal> personals = Arrays.asList(personal1, personal2);
        personals.stream()
                .flatMap(personal -> personal.getTagList().stream())
                // 抽烟 喝酒 烫头 编码 喝酒 踢足球
                .forEach(s -> System.out.print(s + " "));
    }

    // map()函数 对流中所有元素做统一处理
    private static void map() {
        List<String> filterTempList = Arrays.asList("刘一手", "杜子腾", "林大蛋", "Ekko");
        List<String> filterResultTempList = filterTempList.stream()
                .map(s -> "姓名：" + s)
                .collect(Collectors.toList());
        // [姓名：刘一手, 姓名：杜子腾, 姓名：林大蛋, 姓名：Ekko]
        System.out.println(filterResultTempList);
    }

    /** filter条件过滤测试 */
    private static void filterTest() {
        List<User> users = new ArrayList<>();
        User user1 = new User("xia", "男", 32);
        users.add(user1);
        User user2 = new User("wu", "女", 32);
        users.add(user2);
        User user3 = new User("xia", "女", 34);
        users.add(user3);
        System.out.println(users);

        // filter:条件过滤， 过滤出匹配的对象集合
        List<User> filterUsers = users.stream().filter(user ->
                StringUtils.equals(user.getName(), "xia")
        ).collect(Collectors.toList());
        System.out.println(filterUsers); // [User{name='xia', sex='男', age=32}, User{name='xia', sex='女', age=34}]

        List<String> filterTempList = Arrays.asList("刘一手", "杜子腾", "林大蛋", "Ekko");
        List<String> filterResultTempList = filterTempList.stream()
                .filter(s -> s.contains("大"))
                .collect(Collectors.toList());
        System.out.println(filterResultTempList); // [林大蛋]
    }
}
