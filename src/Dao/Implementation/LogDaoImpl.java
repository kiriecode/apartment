package Dao.Implementation;

import ApartmentUtil.DateFormat;
import Dao.BaseDao;
import Dao.Interfaces.LogDao;
import Po.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDaoImpl extends BaseDao implements LogDao {
    @Override
    public List<Log> selectAll() {
        List<Log> logList = new ArrayList<>();
        String sql = "select * from `log`";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Log log = new Log();
                log.setLog_id(rs.getInt("log_id"));
                log.setAccount_id(rs.getString("account_id"));
                log.setType(rs.getInt("type"));
                log.setBuilding_id(rs.getString("building_id"));
                log.setDorm_id(rs.getString("dorm_id"));
                log.setDate(rs.getString("date"));
                logList.add(log);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return logList;
    }

    @Override
    public int addLog(Log log) {
        int res = 0;
        String sql1 = "insert into `log` values (null, ?, ?, ?, ?, ?, ?)";
        String sql2 = "insert into `log` (log_id, account_id, type, date) values (null, ?, ?, ?)";
        try {
            conn = getConnection();
            if(log.getType() == 1) {
                pst = conn.prepareStatement(sql1);
                pst.setString(1, log.getAccount_id());
                pst.setInt(2, log.getType());
                pst.setString(3, log.getBuilding_id());
                pst.setString(4, log.getDorm_id());
                pst.setDouble(5, log.getPayment_account());
                pst.setString(6, DateFormat.nowToDateTime());
                res = pst.executeUpdate();
            } else if(log.getType() == 2 || log.getType() == 3) {
                pst = conn.prepareStatement(sql2);
                pst.setString(1, log.getAccount_id());
                pst.setInt(2, log.getType());
                pst.setString(3, DateFormat.nowToDateTime());
                res = pst.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
