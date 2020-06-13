package mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {
    //定义 SqlSessionFactory
    private static SqlSessionFactory factory=null;
    static {
        //使用静态块创建一次SqlSessionFactory
        try{
            String config="mybatis.xml";
            InputStream in = Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);
        }catch (Exception e){
            factory=null;
            e.printStackTrace();
        }
    }

    /* 获取 SqlSession 对象 */
    public static SqlSession getSqlSession(){
        SqlSession session = null;
        if( factory != null){
            session = factory.openSession();
        }
        return session;
    }

}
