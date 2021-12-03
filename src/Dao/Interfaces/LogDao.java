package Dao.Interfaces;

import Po.Log;

import java.util.List;

public interface LogDao {
    // note 查找全部
    public List<Log> selectAll();
    // note 添加log到表中
    public int addLog(Log log);
}
