package ApartmentService;

import Controller.Implementation.BizImpl;
import Controller.Interfaces.Biz;
import Dao.Implementation.RegisterDaoImpl;
import Dao.Interfaces.RegisterDao;
import Ex.NoSuchAccountException;
import Ex.PasswordWrongException;
import Po.*;

import javax.swing.*;
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
    public static void studentTable(Student student) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while (true) {
            System.out.println("欢迎同学：" + student.getName());
            System.out.println("1 - 查看\\修改个人信息\n2 - 查看\\修改所在宿舍信息\n3 - 查看所在楼宇信息\n4 - 签到\n5 - 签退\n6 - 宿舍缴费\n7 - 注销账户");
            System.out.print("请选择：");
            int op = re.nextInt();
            if(op == 1) {
                try {
                    biz.studentShow(student.getStudent_id());
                } catch (NoSuchAccountException e) {
                    System.out.println("账户不存在");
                }
                System.out.println("1 - 修改信息\n2 - 返回学生界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                }
            } else if(op == 2) {

            } else if(op == 3) {

            } else if(op == 4) {

            } else if(op == 5) {

            } else if(op == 6) {

            } else if(op == 7) {
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
            studentTable(student); // exp 进入学生界面
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
