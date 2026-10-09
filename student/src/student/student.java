package student;

import java.util.ArrayList;
import java.util.Scanner;

public class student {
    private String id;
    private String name;
    private int age;
    private String home;

    public student() {
    }

    public student(String id, String name, int age, String home) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public static void main(String[] args) {
        ArrayList<student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:while (true) {
            System.out.println("…………欢迎来到学校…………");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出系统");
            System.out.println("请输入你的选择：");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    addStudent(list, sc);
                    break;
                case "2":
                    deleteStudent(list, sc);
                    break;
                case "3":
                    modifyStudent(list, sc);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("退出系统");
                    break loop;
                default:
                    System.out.println("输入错误");
            }
        }
    }

    public static void addStudent(ArrayList<student> list, Scanner sc) {
        System.out.println("请输入学生id：");
        String id = sc.next();
        for (student s : list) {
            if (s.getId().equals(id)) {
                System.out.println("该id已存在，添加失败");
                return;
            }
        }
        System.out.println("请输入学生name：");
        String name = sc.next();
        System.out.println("请输入学生age：");
        int age = sc.nextInt();
        System.out.println("请输入学生home：");
        String home = sc.next();
        student s = new student(id, name, age, home);
        list.add(s);
        System.out.println("添加学生成功");
    }

    public static void deleteStudent(ArrayList<student> list, Scanner sc) {
        System.out.println("请输入要删除的学生id：");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("删除学生成功");
                return;
            }
        }
        System.out.println("未找到该学生");
    }

    public static void modifyStudent(ArrayList<student> list, Scanner sc) {
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        for (student s : list) {
            if (s.getId().equals(id)) {
                System.out.println("请输入新的name：");
                s.setName(sc.next());
                System.out.println("请输入新的age：");
                s.setAge(sc.nextInt());
                System.out.println("请输入新的home：");
                s.setHome(sc.next());
                System.out.println("修改学生成功");
                return;
            }
        }
        System.out.println("未找到该学生");
    }

    public static void queryStudent(ArrayList<student> list) {
        if (list.size() == 0) {
            System.out.println("没有学生信息");
            return;
        }
        System.out.println("id\tname\tage\thome");
        for (student s : list) {
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getHome());
        }
    }
}