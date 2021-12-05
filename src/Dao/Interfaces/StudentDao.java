package Dao.Interfaces;

import Ex.InputValueException;
import Po.Student;

import java.util.List;

public interface StudentDao {
    // note 通过id查找
    public Student selectById(String student_id);
    // note 查找全部学生
    public List<Student> selectAll();
    // note 添加student到表中
    public int addStudent(Student student);
    // note 通过id修改为新的student
    public int updateStudent(String student_id, Student student);
    // note 通过id删除
    public int deleteStudent(String student_id);
    // note 签到
    public int signIn(String student_id);
    // note 签退
    public int signOut(String student_id);
    // note 缴费
    public int saveMoney(String student_id, double value) throws InputValueException;
}
