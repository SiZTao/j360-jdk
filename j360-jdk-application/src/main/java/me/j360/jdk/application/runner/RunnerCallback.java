package me.j360.jdk.application.runner;


import me.j360.jdk.application.core.common.support.JobWrapper;
import me.j360.jdk.application.runner.domain.Response;

public interface RunnerCallback {

    /**
     * ִ�����, �����ǳɹ�, Ҳ������ʧ��
     * @param response
     * @return ������µ�����, ��ô�����µ��������
     */
    public JobWrapper runComplete(Response response);

}
