package Dao.Implementation;

import ApartmentUtil.DateFormat;
import Dao.BaseDao;
import Dao.Interfaces.StudentDao;
import Ex.InputValueException;
import Po.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public Student selectById(String student_id) {
        Student student = null;
        String sql = "select * from `student` where `student_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            rs = pst.executeQuery();
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
                student.setBuilding_id(rs.getString("building_id"));
                student.setDorm_id(rs.getString("dorm_id"));
                student.setBed_id(rs.getInt("bed_id"));
                student.setStatus(rs.getInt("status"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from student";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getString("birthday"));
                student.setContact(rs.getString("contact"));
                student.setStudent_id(rs.getString("name"));
                student.setCollege(rs.getString("college"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getString("classes"));
                student.setBuilding_id(rs.getString("building_id"));
                student.setDorm_id(rs.getString("dorm_id"));
                student.setBed_id(rs.getInt("bed_id"));
                student.setStatus(rs.getInt("status"));
                studentList.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public int addStudent(Student student) {
        int res = 0;
        String sql = "insert into `student` values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getGender());
            pst.setString(3, student.getBirthday());
            pst.setString(4, student.getContact());
            pst.setString(5, student.getStudent_id());
            pst.setString(6, student.getCollege());
            pst.setString(7, student.getMajor());
            pst.setString(8, student.getClasses());
            pst.setString(9, student.getBuilding_id());
            pst.setString(10, student.getDorm_id());
            pst.setInt(11, student.getBed_id());
            pst.setInt(12, student.getStatus());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateStudent(String student_id, Student student) {
        int res = 0;
        String sql = "update student set name = ?, gender = ?, birthday = ?, contact = ?, college = ?, major = ?, classes = ?, building_id = ?, dorm_id = ?, bed_id = ?, status = ? where student_id = ?";
        Student student1 = selectById(student_id);
        if(student.equals(student1)) {
            // todo 抛出异常：无更新
            return -1;
        }
        // todo 数据异常...
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getGender());
            pst.setString(3, student.getBirthday());
            pst.setString(4, student.getContact());
            pst.setString(5, student.getCollege());
            pst.setString(6, student.getMajor());
            pst.setString(7, student.getClasses());
            pst.setString(8, student.getBuilding_id());
            pst.setString(9, student.getDorm_id());
            pst.setInt(10, student.getBed_id());
            pst.setInt(11, student.getStatus());
            pst.setString(12, student_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteStudent(String student_id) {
        int res = 0;
        String sql = "delete from student where student_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int signIn(String student_id) {
        int res1 = 0, res2 = 0;
        String sql = "update `student` set `status` = 1 where `student_id` = ?";
        String sql2 = "insert into `log` (`log_id`, `account_id`, `type`, `date`) values (null, ?, ?, ?)";
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res1 = pst.executeUpdate();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, student_id);
            pst.setInt(2, 2);
            pst.setString(3, DateFormat.nowToDateTime());
            res2 = pst.executeUpdate();
            System.out.println("res1 = " + res1 + "   res2 = " + res2);
            if(res1 * res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res1 * res2;
    }

    @Override
    public int signOut(String student_id) {
        int res1 = 0, res2 = 0;
        String sql = "update `student` set `status` = 0 where `student_id` = ?";
        String sql2 = "insert into `log` (`log_id`, `account_id`, `type`, `date`) values (null, ?, ?, ?)";
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res1 = pst.executeUpdate();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, student_id);
            pst.setInt(2, 3);
            pst.setString(3, DateFormat.nowToDateTime());
            res2 = pst.executeUpdate();
            System.out.println("res1 = " + res1 + "   res2 = " + res2);
            if(res1 * res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res1 * res2;
    }

    @Override
    public int saveMoney(String student_id, double value) throws InputValueException {
        if(value < 0) {
            throw new InputValueException(value);
        }
        int res = 0;
        String sql = "update `dorm` set `deposit` = deposit + ? where `building_id` = ? and `dorm_id` = ?";
        Student student = selectById(student_id);
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, value);
            pst.setString(2, student.getBuilding_id());
            pst.setString(3, student.getDorm_id());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
