package com.sm.cn.test;

import com.sm.cn.entity.Book;
import com.sm.cn.entity.Booktype;
import com.sm.cn.mapper.AdminMapper;
import com.sm.cn.entity.Admin;
import com.sm.cn.service.AdminService;
import com.sm.cn.service.BookService;
import com.sm.cn.service.BooktypeService;
import com.sm.cn.service.impl.AdminServiceImpl;
import com.sm.cn.util.MybatisUtils;
import com.sm.cn.vo.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public  void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooktypeService bean = context.getBean(BooktypeService.class);
        System.out.println(bean);
        List<Booktype> booktypeByParentId = bean.getBooktypeByParentId(0);
        System.out.println(booktypeByParentId);

        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper bean = context.getBean(AdminMapper.class);
        System.out.println(bean);
        List<Admin> admins = bean.queryAll();
        System.out.println(admins);*/

        /*SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        System.out.println(mapper);
        List<Admin> admins = mapper.queryAll();
        System.out.println(admins);*/
    }
}
