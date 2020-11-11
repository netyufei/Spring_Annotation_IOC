package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /*

    * 获取Spring的IOC核心容器，并根据id来获取对象*/
    public static void main(String[] args){
        //1.获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountServiceImpl");
        //IAccountDao adao= applicationContext.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        //System.out.println(adao);
        //as.saveAccount();
        }
}
