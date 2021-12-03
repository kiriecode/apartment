package Controller.Implementation;

import Controller.Interfaces.Controller;
import Po.Student;

import java.sql.SQLException;

public class ControllerImpl {


    /*@Override
    public boolean signIn(String student_id) throws SQLException, ClassNotFoundException {
        // x0 建立链接，关闭回滚
        con = getConnection();
        con.setAutoCommit(false);

        // x1 查询状态
//        Student student = selectById(student_id);
//        if(student.getStatus() == 1) {
//            // todo 抛出异常：已经签到
//            return false;
//        }
        // x2 修改学生状态
        String sql1 = "update `student` set `status` = 1 where student_id = ?";
        pst = con.prepareStatement(sql1);
        pst.setString(1, student_id);
        int res1 = pst.executeUpdate();
        System.out.println("res1 = " + res1);

        // x3 添加记录
        String sql2 = "insert into `operation` (`account_id`, `type`, `date`) values (?, ?, ?)";
        pst = con.prepareStatement(sql2);
        pst.setString(1, student_id);
        pst.setInt(2, 2);
        pst.setString(3, DateFormat.nowToDateTime());
        int res2 = pst.executeUpdate();
        System.out.println("res2 = " + res2);

        // 4 提交事务
        if(res1 * res2 > 0) {
            System.out.println("c1");
            con.commit();
            System.out.println("c2");
        } else {
            System.out.println("c3");
            con.rollback();
            System.out.println("c4");
        }
        return res1 * res2 > 0;
    }*/
}
