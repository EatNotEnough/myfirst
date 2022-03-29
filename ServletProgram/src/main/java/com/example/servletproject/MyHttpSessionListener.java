package com.example.servletproject;

/**
 * @author xie
 * @create 2022-03-2022/3/24 8:42
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����HttpSession���󴴽������ٵļ�����
 * * �¼�Դ��HttpSession
 * * ��������MyHttpSessionListener
 * * �¼�Դ�ͼ������󶨣�ͨ�����÷�ʽ��web.xml����
 */
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    // ����HttpSession�Ĵ���
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("HttpSession创建");
    }

    @Override
    // ����HttpSession������
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("HttpSession销毁");
    }

}

