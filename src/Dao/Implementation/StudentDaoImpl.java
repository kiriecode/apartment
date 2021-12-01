package Dao.Implementation;

import Dao.BaseDao;
import Dao.Interfaces.StudentDao;
import Po.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public Student selectById(String student_id) throws SQLException, ClassNotFoundException {
        con = getConnection();
        String sql = "select * from student where student_id = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, student_id);
        rs = pst.executeQuery();
        Student student = null;
        if(rs.next()) {
            student = new Student();
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setBirthday(rs.getString("birthday"));
            student.setContact(rs.getString("contact"));
            student.setStudent_id(student_id);
            student.setCollege(rs.getString("college"));
            student.setMajor(rs.getString("major"));
            student.setClasses(rs.getString("classes"));
            student.setDorm_id(rs.getString("dorm_id"));
            student.setBed_id(rs.getInt("bed_id"));
            student.setStatus(rs.getInt("status"));
        }
        return student;
    }

    @Override
    public boolean signIn(String student_id) throws SQLException, ClassNotFoundException {
        // 0 建立链接，关闭回滚
        con = getConnection();
        con.setAutoCommit(false);
        String sql1 = "select * from student where student_id = ?";
//        String sql2 = "update student set ";

        // 1 查询状态

        // 2 修改学生状态
        // 3 添加记录
        PreparedStatement pst = con.prepareStatement(sql1);
        return false;
    }

    @Override
    public boolean signOut(String student_id) throws SQLException {
        return false;
    }

    @Override
    public int saveMoney(String dorm_id, int value) {
        return 0;
    }
}
