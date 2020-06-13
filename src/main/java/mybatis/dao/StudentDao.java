package mybatis.dao;

import mybatis.domain.Student;

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
}
