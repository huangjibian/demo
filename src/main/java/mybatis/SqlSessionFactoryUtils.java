package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2018/8/15.
 */
public class SqlSessionFactoryUtils {
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
    private  static SqlSessionFactory SqlSessionFactory = null;
    private SqlSessionFactoryUtils(){

    }
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if (SqlSessionFactory != null){
                return SqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
             inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch ( IOException e){
                e.printStackTrace();
                return null;
            }
            return SqlSessionFactory;
        }
    }
    public static SqlSession openSqlSession(){
        if (SqlSessionFactory ==null){
            getSqlSessionFactory();
        }
        return SqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        Logger log = Logger.getLogger(SqlSessionFactoryUtils.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            //System.out.println(sqlSession.getClass().getName());
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            System.out.println(roleMapper);
            roleMapper.getRole(1L);

            //System.out.println(RoleMapper.class.getName());
           // System.out.println(roleMapper.getClass().getName());
            Role role = roleMapper.getRole((long) 2);
            System.out.println("3333");
            log.info(role.getRoleName());
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }


}
