package Controller.Interfaces;

import Ex.InputValueException;
import Ex.NoSuchAccountException;
import Ex.PasswordWrongException;
import Po.Manager;
import Po.Register;
import Po.Student;

import java.sql.SQLException;
import java.util.Map;

public interface Biz {
    // note 登录
    public int Login(String account, String password) throws NoSuchAccountException, PasswordWrongException;
    // note 查找学生
    public Student selectStudentById(String student_id);
    // note 查找管理员
    public Manager selectManagerById(String manager_id);
    // note 展示学生个人信息
    public void studentShowOnAll(Student student) throws NoSuchAccountException;
    // note 展示管理员个人信息
    public void managerShowOnAll(Manager manager);
    // note 展示宿舍信息
    public void dormShowOnStudent(String building_id, String dorm_id) throws NoSuchAccountException;
    // note 展示楼宇信息
    public void buildingShowOnStudent(Student student) throws NoSuchAccountException;
    // note 通过id签到
    public boolean signIn(String student_id) ;
    // note 通过id签退
    public boolean signOut(String student_id) ;
    // note 缴费
    public boolean saveMoney(String building_id, String dorm_id, double value) throws InputValueException;
}
