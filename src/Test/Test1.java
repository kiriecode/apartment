package Test;

import Dao.Implementation.DormDaoImpl;
import Dao.Implementation.ManagerDaoImpl;
import Dao.Implementation.StudentDaoImpl;
import Dao.Interfaces.DormDao;
import Dao.Interfaces.ManagerDao;
import Dao.Interfaces.StudentDao;
import Po.Dorm;
import Po.Manager;
import Po.Student;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String id1 = "19110103024";
        StudentDao studentDao = new StudentDaoImpl();
        ManagerDao managerDao = new ManagerDaoImpl();
        DormDao dormDao = new DormDaoImpl();
        // note


        // note 查询所有
        List<Student> studentList = studentDao.selectAll();
        for(Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();
        List<Manager> managerList = managerDao.selectAll();
        for(Manager manager : managerList) {
            System.out.println(manager);
        }
        System.out.println();
        List<Dorm> dormList = dormDao.selectAll();
        for(Dorm dorm : dormList) {
            System.out.println(dorm);
        }
    }
}
