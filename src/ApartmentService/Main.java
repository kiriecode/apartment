package ApartmentService;

import Controller.Implementation.BizImpl;
import Controller.Interfaces.Biz;
import Dao.Implementation.RegisterDaoImpl;
import Dao.Interfaces.RegisterDao;
import Dao.Interfaces.StudentDao;
import Ex.NoSuchAccountException;
import Ex.PasswordWrongException;
import Po.*;

import java.util.Scanner;

public class Main {
    public static Biz biz = new BizImpl();
    public static RegisterDao registerDao = new RegisterDaoImpl();
    public static Scanner re = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner rea = new Scanner(System.in);

        while (true) {
            System.out.println("-- Welcome --");
            System.out.println("1 - 学生登录\n2 - 宿管登录\n3 - 超级管理员登录\n4 - 退出");
            System.out.print("请选择: ");
            int op = rea.nextInt();
            if(op == 1) {
                studentLogin();
            } else if(op == 2) {
                managerLogin();
            } else if(op == 3) {
                superManagerLogin();
            } else if(op == 4) {
                break;
            }
        }
        System.out.println("goodbye!");
        rea.close();
    }
    // x1-1 学生界面
    public static void studentTable(String student_id) {
        System.out.println("\n\n\n\n\n\n\n");
        while (true) {
            Student student = biz.selectById(student_id);
            System.out.println("\n\n\n\n欢迎同学：" + student.getName());
            int status = student.getStatus();
            System.out.println("1 - 查看\\修改个人信息\n2 - 查看\\修改所在宿舍信息\n3 - 查看所在楼宇信息\n4 - " + (status == 0 ? "签到" : "签退") + "\n5 - 宿舍缴费\n6 - 注销账户");
            System.out.print("请选择：");
            int op = re.nextInt();
            if(op == 1) {
                try {
                    biz.studentStudentShow(student);
                } catch (NoSuchAccountException e) {
                    System.out.println("账户不存在");
                }
                System.out.println("1 - 修改信息\n2 - 返回学生界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                }
            } else if(op == 2) {
                try {
                    biz.dormStudentShow(student.getBuilding_id(), student.getDorm_id());
                } catch (NoSuchAccountException e) {
                    System.out.println("账户不存在");
                }
                System.out.println("1 - 修改信息\n2 - 返回学生界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                }
            } else if(op == 3) {
                try {
                    biz.buildingStudentShow(student);
                } catch (NoSuchAccountException e) {
                    System.out.println("楼宇不存在");
                }
                System.out.println("输入任意字符并回车以继续");
                re.next();
            } else if(op == 4) {
                if(status == 0) {
                    System.out.println(biz.signIn(student.getStudent_id()) ?"签到成功！" : "签到失败！");
                } else {
                    System.out.println(biz.signOut(student.getStudent_id()) ?"签退成功！" : "签退失败！");
                }
            } else if(op == 5) {

            } else if(op == 6) {
                break;
            } else {
                System.out.print("输入错误, 即将返回学生界面");
            }
        }
    }
    // x0-1 学生登录
    public static void studentLogin() {
        Student student = null;
        Register register = new Register();
        register.setIdentity(1);
        System.out.print("account: ");
        register.setAccount(re.next());
        System.out.print("password: ");
        register.setPassword(re.next());
        try {
            student = biz.login(register);
        } catch (NoSuchAccountException e) {
            System.out.println("账户不存在");
        } catch (PasswordWrongException e) {
            System.out.println("账户或密码错误");
        }
        if(student != null) {
            System.out.println("login success!");
            System.out.println("----------------------------------");
            studentTable(student.getStudent_id()); // exp 进入学生界面
        } else {
            System.out.println("password wrong!");
        }
    }
    // x0-2 宿管登录
    public static void managerLogin() {

    }
    // x0-3 超级管理员登陆
    public static void superManagerLogin() {

    }
}
