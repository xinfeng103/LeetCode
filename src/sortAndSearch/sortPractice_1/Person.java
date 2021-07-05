package sortAndSearch.sortPractice_1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 todo:List<Person> list;
  对这个 list 做下排序
  注意：同龄的只保留身高最高的，同龄且身高相同，则只输出 id 最大的
  class Person {
     private Integer id;
     private Integer age;
     private Integer height;
  }
 */
public class Person {
    private Integer id;
    private Integer age;
    private Integer height;

    public Person(Integer id, Integer age, Integer height) {
        this.id = id;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

class PersonTest {
    public static void main(String[] args) {
        List<Person> list = new LinkedList<Person>();
        list.add(new Person(1, 12, 21));
        list.add(new Person(2, 21, 22));
        list.add(new Person(3, 11, 20));
        list.add(new Person(4, 15, 18));
        list.add(new Person(5, 14, 19));
        list.add(new Person(6, 12, 20));
        list.add(new Person(7, 12, 20));
        list.add(new Person(8, 16, 17));
        for (Person person : list) {
            System.out.println("排序前" + person);
        }
        System.out.println("========================================================================");
        list.sort(new Comparator<>() {
            int flag = 0;

            @Override
            public int compare(Person o1, Person o2) {

                if (o1.getAge() < o2.getAge()) {
                    return 1;
                } else if (o1.getAge() == o2.getAge()) {
                    if (o1.getHeight() < o2.getHeight()) {
                        return 1;
                    } else if (o1.getAge() == o2.getAge()) {
                        if (o1.getId() < o2.getId()) {
                            return 1;
                        }
                    }
                }
                return -1;
            }
        });
        for (Person person1 : list) {
            System.out.println("排序后" + person1);
        }
    }
}
