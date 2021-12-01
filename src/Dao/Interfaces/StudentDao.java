package Dao.Interfaces;

import Po.Student;

import java.sql.SQLException;

public interface StudentDao {
    // note 通过id查找
    public Student selectById(String student_id) throws SQLException, ClassNotFoundException;
    // note 通过id签到
    public boolean signIn(String student_id) throws SQLException, ClassNotFoundException;
    // note 通过id签退
    public boolean signOut(String student_id) throws SQLException;
    // note 缴费
    public int saveMoney(String dorm_id, int value);

}
