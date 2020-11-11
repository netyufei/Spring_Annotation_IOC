package com.itheima.test;

import com.itheima.config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest {


    @Test
    public void testFindAll() {//查询所有
        //1.获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        //1.获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //1.获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1.获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        //3.执行方法
        as.deleteAccount(4);
    }
}
