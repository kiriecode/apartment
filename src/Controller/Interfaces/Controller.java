package Controller.Interfaces;

import Po.Manager;
import Po.Student;

import java.sql.SQLException;

public interface Controller {
    // x1 学生
    // note 学生开户/注册
    public boolean studentRegister(Student student);
    // note 修改个人信息
    public boolean studentUpdate(Student student);
    // note 查询个人信息
    public Student studentSearch(String student_id);
    // note 销户
    public boolean studentCancellation(String student_id);

    // x2 管理员
    // note 管理员开户/注册
    public boolean managerRegister(Manager manager);
    // note 修改个人信息
    public boolean managerUpdate(Manager manager);
    // note 查询个人信息
    public Manager managerSearch(String manager_id);
    // note 销户
    public  boolean managerCancellation(String manager_id);

    // x3 宿舍

    // x4 楼宇

    // x5 其他
    // note 通过id签到
    public boolean signIn(String student_id) throws SQLException, ClassNotFoundException;
    // note 通过id签退
    public boolean signOut(String student_id) throws SQLException;
    // note 缴费
    public int saveMoney(String dorm_id, int value);
}
