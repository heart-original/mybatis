package mybatis.dao;

import mybatis.domain.Student;
import mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession session= MyBatisUtils.getSqlSession();
        List<Student> studentList=session.selectList("mybatis.dao.StudentDao.selectStudents");
        session.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtils.getSqlSession();
        int nums = session.insert("mybatis.dao.StudentDao.insertStudent",student);
        session.commit();
        session.close();
        return nums;

    }

    @Override
    public int updateStudent(Student student) {
        SqlSession session = MyBatisUtils.getSqlSession();
        int nums = session.insert(
                "mybatis.dao.StudentDao.updateStudent",student);
        session.commit();
        session.close();
        return nums;
    }

    @Override
    public int deleteStudent(int id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        int nums = session.insert("mybatis.dao.StudentDao.deleteStudent",1006);
        session.commit();
        session.close();
        return nums;

    }

    @Override
    public Student selectById(int id) {
        return null;
    }

    @Override
    public List<Student> selectStudentIf(Student student) {
        return null;
    }

    @Override
    public List<Student> selectMultiParam(String name, int age) {
        return null;
    }

    @Override
    public List<Student> selectStudentWhere(Student student) {
        return null;
    }

    @Override
    public List<Student> selectStudentForList(List<Integer> idList) {
        return null;
    }
}