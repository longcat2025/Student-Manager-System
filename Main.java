import java.util.ArrayList;
import java.util.Scanner;

/*欢迎使用学生成绩管理系统：
        1. 添加学生
        2. 显示全部学生
        3. 查找学生
        4. 修改学生成绩
        5. 删除学生
        6. 统计成绩
        7. 退出系统
        请输入你的选择：*/
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Student student = new Student("example",-1,"A0000");
        studentArrayList.add(student);
        Menu(studentArrayList);
    }
    //
    public static void Menu(ArrayList<Student> studentArrayList){
        while(true){
            System.out.println("欢迎使用学生成绩管理系统：");
            System.out.print("|1. 添加学生");
            System.out.println("|2. 显示全部学生  ");
            System.out.print("|3. 查找学生");
            System.out.println("|4. 修改学生成绩  ");
            System.out.print("|5. 删除学生");
            System.out.println("|6. 统计成绩  ");
            System.out.print("|7. 退出系统");
            System.out.println("|8. 关于作者");
            System.out.println("请输入你的选择：");
            int choose = sc.nextInt();
            if (choose == 1) {
                AddStudent(studentArrayList);

            } else if (choose == 2) {
                ShowStudent(studentArrayList);

            } else if (choose == 3) {
                System.out.println("|输入id使用ID查询,输入name使用Name查询");
                String chose = sc.next();
                if (chose.equals("id")){
                    System.out.println("|输入查询的ID");
                    String id = sc.next();
                    FindStudent_ID(studentArrayList,id);
                }

                if (chose.equals("name")){
                    System.out.println("|输入查询的Name");
                    String name = sc.next();
                    FindStudent_Name(studentArrayList,name);
                }

            } else if (choose == 4) {
                System.out.println("|输入ID查找要修改的学生");
                String findID = sc.next();
                ChangeGrade(studentArrayList,findID);
            } else if (choose == 5) {
                System.out.println("|输入ID查找要删除的学生");
                String delID = sc.next();
                DelStudent(studentArrayList,delID);
            } else if (choose == 6) {
                ClearGrade(studentArrayList);
            } else if (choose == 7) {
                return;
            } else if (choose == 8){
                About();
            } else {
                System.out.println("|输入内容不合法,请重新输入");
            }
        }

    }

    public static void About() {
        System.out.println("|作者: longcat233");
        System.out.println("|只是一个Java小白");
        System.out.println("|详情见github->longcat233");
        System.out.println("|QQ:3910778818");
        System.out.println("|Email:longcat2025@outlook.com");
        System.out.println("|飞向天空!让我们开始吧!");
        BackMenu();
    }

    //
    public static void AddStudent(ArrayList<Student> studentArrayList){
        Student student = new Student();
        System.out.println("|请输入学生名字");
        String name = sc.next();
        student.setName(name);
        System.out.println("|请输入学生成绩");
        double grade = sc.nextDouble();
        if (!(grade >= 0 && grade <= 120)){
            System.out.println("|输入成绩不合法");
            return;
        }
        student.setGrade(grade);
        System.out.println("|请输入学生ID");
        System.out.println("|学生ID为1位大写字母,4位数字,从后到前->如A0001");
        String id = sc.next();
        boolean checkIdResult = CheckID(studentArrayList,id);
        boolean ft_Id = FT_ID(id);
        if (checkIdResult){
            System.out.println("|ID 重复,请重新输入");
            System.out.println("|添加失败|");
            return;
        }
        if (!ft_Id){
            System.out.println("|ID 不合规,请重新输入");
            System.out.println("|添加失败|");
            return;
        }
        student.setID(id);

        studentArrayList.add(student);
        System.out.println("|添加成功!|");
    }

    public static boolean CheckID(ArrayList<Student> studentArrayList,String id){
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (student.getID().equals(id)){
                return true;
            }
        }
        return false;
    }

    public static void ShowStudent(ArrayList<Student> studentArrayList){
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (!(student.getID().equals("A0000"))){
                if (studentArrayList.size() == 1){
                    System.out.println("|查找无结果");
                }
                System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
            }
        }
        BackMenu();
    }

    public static void FindStudent_ID(ArrayList<Student> studentArrayList,String id){
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (student.getID().equals(id)){
                System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
            }
        }
        BackMenu();
    }

    public static void FindStudent_Name(ArrayList<Student> studentArrayList,String name){
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (student.getName().equals(name)){
                System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
            }
        }
        BackMenu();
    }

    public static void BackMenu() {
        while(true){
            System.out.println("输入back返回主菜单");
            String back = sc.next();
            if (back.equals("back")){
                break;
            } else {
                System.out.println("|输入不合法");
            }
        }
    }

    public static void ChangeGrade(ArrayList<Student> studentArrayList,String id){
        boolean have = false;
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (id.equals("A0000")){
                System.out.println("|查找无结果");
                return;
            }
            if (student.getID().equals(id)){
                System.out.println("|查找结果为->");
                System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
                have = true;
            }
        }

        if (!have){
            System.out.println("|查找无结果");
            return;
        }

        if (have){
            System.out.println("|输入修改成绩的值...");
            double grade = sc.nextDouble();
            for (int i = 0; i < studentArrayList.size(); i++) {
                Student student = studentArrayList.get(i);
                if (student.getID().equals(id)){
                    System.out.println("|修改成功!|");
                    System.out.println("|修改前->");
                    System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
                    student.setGrade(grade);
                    System.out.println("|修改后->");
                    System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
                }
            }
        }
        BackMenu();
    }

    public static void DelStudent(ArrayList<Student> studentArrayList,String id){
        boolean have = false;
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (! (id.equals("A0000"))){
                if (student.getID().equals(id)){
                    have = true;
                    System.out.println("|查找结果为->");
                    System.out.println("|名字:" + student.getName() + "|成绩:" + student.getGrade() + "|ID:" + student.getID());
                    System.out.println("|确认删除吗? 不可复原!");
                    System.out.println("|输入yes OR not");
                    String chose = sc.next();
                    if (chose.equals("yes")){
                        studentArrayList.remove(i);
                        System.out.println("|删除成功!|");
                        BackMenu();
                    } else if (chose.equals("not")) {
                        return;
                    }
                }
            }
        }
        if (!have){
            System.out.println("|查找无结果");
        }
        BackMenu();
    }

    public static void ClearGrade(ArrayList<Student> studentArrayList){
        double sumResult = 0;
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (! (student.getID().equals("A0000") ) ){
                sumResult = sumResult + student.getGrade();
            }
        }
        double result = sumResult / (studentArrayList.size() - 1);
        System.out.println("|平均成绩为" + result);
        System.out.println("|总人数为" + (studentArrayList.size() - 1));
        BackMenu();
    }

    public static boolean FT_ID(String id){
        if (id.length() != 5){
            return false;
        }

        if (!(id.charAt(0) >= 'A' && id.charAt(0) <= 'Z')){
            System.out.println("ID不合法");
            return false;
        }

        for (int i = 1; i < id.length(); i++) {
            if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
}