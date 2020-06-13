package mybatis.dao;

import mybatis.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    /*查询所有数据*/
    List<Student> selectStudents();

    /*插入学生数据*/
    int insertStudent(Student student);

    /*更新学生数据*/
    int updateStudent(Student student);

    /*删除学生数据*/
    int deleteStudent(int id);

    /*传参：一个简单参数*/
    Student selectById(int id);

    /*多参数使用*/
    List<Student> selectMultiParam(@Param("personName") String name,@Param("personAge") int age);

    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    /*查询学生id为。。。。*/
    List<Student> selectStudentForList(List<Integer> idList);
}
