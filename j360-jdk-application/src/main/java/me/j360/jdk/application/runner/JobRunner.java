package me.j360.jdk.application.runner;


import me.j360.jdk.application.core.common.support.Job;


public interface JobRunner {

    /**
     * ִ������
     * �׳��쳣������ʧ��, ����null����Ϊ�����ѳɹ�
     */
    public Result run(Job job) throws Throwable;

}
