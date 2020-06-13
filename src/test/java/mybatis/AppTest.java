package mybatis;

import static org.junit.Assert.assertTrue;

import mybatis.dao.StudentDao;
import mybatis.dao.StudentDaoImpl;
import mybatis.domain.Student;
import mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testStart() throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        List<Student> studentList=sqlSession.selectList("mybatis.dao.StudentDao.selectStudents");
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        Student student=new Student();
        student.setId(1004);
        student.setName("lily");
        student.setEmail("456.com");
        student.setAge(21);
        int rows=sqlSession.insert("mybatis.dao.StudentDao.insertStudent",student);
        sqlSession.commit();
        System.out.println("增加记录的行数："+rows);
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        Student student=new Student();
        student.setAge(22);
        student.setId(1004);
        student.setName("lily");
        int rows=sqlSession.insert("mybatis.dao.StudentDao.updateStudent",student);
        sqlSession.commit();
        System.out.println("修改记录的行数："+rows);
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        int id=1004;
        int rows=sqlSession.insert("mybatis.dao.StudentDao.deleteStudent",id);
        sqlSession.commit();
        System.out.println("删除记录的行数："+rows);
        sqlSession.close();
    }

    @Test
    public void testUtils() throws IOException {
        SqlSession session= MyBatisUtils.getSqlSession();
        List<Student> studentList=session.selectList("mybatis.dao.StudentDao.selectStudents");
        studentList.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testSelectStudents() throws IOException {
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> studentList  = studentDao.selectStudents();
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void testSelect() throws IOException {
        StudentDao studentDao=MyBatisUtils.getSqlSession().getMapper(StudentDao.class);
        final List<Student> studentList = studentDao.selectStudents();
        studentList.forEach( stu -> System.out.println(stu));
    }

    @Test
    public void testNewInsert() throws IOException {
        SqlSession session=MyBatisUtils.getSqlSession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1003);
        student.setName("lily");
        student.setEmail("456.com");
        student.setAge(22);
        int nums =studentDao.insertStudent(student);
        session.commit();
        System.out.println("使用 Dao 添加数据:"+nums);
    }

    @Test
    public void testNewUpdate() throws IOException {
        SqlSession session=MyBatisUtils.getSqlSession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1003);
        student.setAge(21);
        int nums = studentDao.updateStudent(student);
        session.commit();
        System.out.println("使用 Dao 修改数据:"+nums);
    }

    @Test
    public void testNewDelete() throws IOException {
        SqlSession session=MyBatisUtils.getSqlSession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        int nums = studentDao.deleteStudent(1002);
        session.commit();
        System.out.println("使用 Dao 修改数据:"+nums);
    }

}
