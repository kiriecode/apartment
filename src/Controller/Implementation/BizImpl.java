package Controller.Implementation;

import Controller.Interfaces.Biz;
import Dao.Implementation.*;
import Dao.Interfaces.*;
import Ex.InputValueException;
import Ex.NoSuchAccountException;
import Ex.PasswordWrongException;
import Po.*;

import java.sql.SQLException;
import java.util.List;

public class BizImpl implements Biz {
    StudentDao studentDao = new StudentDaoImpl();
    ManagerDao managerDao = new ManagerDaoImpl();
    DormDao dormDao = new DormDaoImpl();
    BuildingDao buildingDao = new BuildingDaoImpl();
    RegisterDao registerDao = new RegisterDaoImpl();
    LogDao logDao = new LogDaoImpl();

    @Override
    public Student login(Register register) throws NoSuchAccountException, PasswordWrongException {
        Student student = null;
        Register register1 = registerDao.selectById(register.getAccount());
        if(register1 == null) { // exp 账户不存在
            throw new NoSuchAccountException(register.getAccount());
        }
        if(register1.equals(register)) {
            student = studentDao.selectById(register.getAccount());
        } else { // exp 账户或者密码错误
            throw new PasswordWrongException();
        }
        return student;
    }

    @Override
    public Student selectById(String student_id) {
        return studentDao.selectById(student_id);
    }

    public void studentStudentShow(Student student) throws NoSuchAccountException {
        System.out.println(student);
    }

    @Override
    public void dormStudentShow(String building_id, String dorm_id) throws NoSuchAccountException {
        Dorm dorm = dormDao.selectById(building_id, dorm_id);
        if(dorm == null) {
            throw new NoSuchAccountException(building_id + "#" + dorm_id);
        }
        System.out.println(dorm);
    }

    @Override
    public void buildingStudentShow(Student student) throws NoSuchAccountException {
        String building_id = student.getBuilding_id();
        Building building = buildingDao.selectById(building_id);
        if(building == null) {
            throw new NoSuchAccountException(building_id);
        }
        System.out.println(building);
        int cnt = 0;
        List<Student> studentList = studentDao.selectAll();
        for(Student student0 : studentList) {
            if(student0.getBuilding_id().equals(building_id)) {
                cnt ++;
            }
        }
        System.out.println("与你住在一栋楼的还有：" + cnt + " 位同学");
        List<Manager> managerList = managerDao.selectAll();
        Manager manager = null;
        for(Manager manager0 : managerList) {
            if(manager0.getManager_id().equals(building.getManager_id())) {
                manager = manager0;
                break;
            }
        }
        if(manager != null) {
            System.out.println("你的宿管阿姨是：" + manager.getName());
        }
    }

    @Override
    public boolean signIn(String student_id) {
        return studentDao.signIn(student_id) > 0;
    }

    @Override
    public boolean signOut(String student_id) {
        return studentDao.signOut(student_id) > 0;
    }

    @Override
    public int saveMoney(String student_id, double value) {
        int res = 0;
        try {
            return studentDao.saveMoney(student_id, value);
        } catch (InputValueException e) {
            e.printStackTrace();
        }
        return res;
    }
}
