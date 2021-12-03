package Test;

import Dao.Implementation.*;
import Dao.Interfaces.*;
import Po.*;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String id1 = "19110103024";
        StudentDao studentDao = new StudentDaoImpl();
        ManagerDao managerDao = new ManagerDaoImpl();
        DormDao dormDao = new DormDaoImpl();
        BuildingDao buildingDao = new BuildingDaoImpl();
        RegisterDao registerDao = new RegisterDaoImpl();
        LogDao logDao = new LogDaoImpl();
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
        System.out.println();
        List<Building> buildingList = buildingDao.selectAll();
        for(Building building : buildingList) {
            System.out.println(building);
        }
        System.out.println();
        List<Register> registerList = registerDao.selectAll();
        for(Register register : registerList) {
            System.out.println(register);
        }
        System.out.println();
        List<Log> logList = logDao.selectAll();
        for(Log log : logList) {
            System.out.println(log);
        }
    }
}
