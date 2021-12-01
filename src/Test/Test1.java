package Test;

import Dao.Implementation.StudentDaoImpl;
import Dao.Interfaces.StudentDao;
import Po.Student;

import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String id1 = "19110103024";
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.selectById(id1);
        System.out.println(student.toString());
    }
}
