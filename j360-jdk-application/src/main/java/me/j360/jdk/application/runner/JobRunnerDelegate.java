package me.j360.jdk.application.runner;


import me.j360.jdk.application.core.common.support.JobWrapper;
import me.j360.jdk.application.core.common.support.SystemClock;
import me.j360.jdk.application.runner.domain.Response;
import me.j360.jdk.application.runner.domain.TaskApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Job Runner �Ĵ�����,
 * 1. ��һЩ������֮���
 * 2. ���ͳ��
 * 3. Context��Ϣ����
 *
 */
public class JobRunnerDelegate implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger("LtsTaskTracker");
    private JobWrapper jobWrapper;
    private RunnerCallback callback;
    private TaskApplication application;

    public JobRunnerDelegate(TaskApplication application,
                             JobWrapper jobWrapper, RunnerCallback callback) {
        this.jobWrapper = jobWrapper;
        this.callback = callback;
        this.application = application;

    }

    @Override
    public void run() {
        try {

            while (jobWrapper != null) {
                long startTime = SystemClock.now();
                // ���õ�ǰcontext�е�jobId
                Response response = new Response();
                response.setJobWrapper(jobWrapper);
                try {
                    application.getRunnerPool().getRunningJobManager()
                            .in(jobWrapper.getJobId());
                    //ִ��������job
                    Result result = application.getRunnerPool().getRunnerFactory()
                            .newRunner().run(jobWrapper.getJob());
                    if (result == null) {
                        response.setAction(Action.EXECUTE_SUCCESS);
                    } else {
                        if (result.getAction() == null) {
                            response.setAction(Action.EXECUTE_SUCCESS);
                        }else{
                            response.setAction(result.getAction());
                        }
                        response.setMsg(result.getMsg());
                    }
                    long time = SystemClock.now() - startTime;
                    LOGGER.info("Job execute finished : {}, time:{} ms.", jobWrapper, time);
                } catch (Throwable t) {
                    StringWriter sw = new StringWriter();
                    t.printStackTrace(new PrintWriter(sw));
                    response.setAction(Action.EXECUTE_EXCEPTION);
                    response.setMsg(sw.toString());
                    long time = SystemClock.now() - startTime;
                    LOGGER.info("Job execute error : {}, time: {}, {}",
                            jobWrapper, time, t.getMessage(), t);
                } finally {
                    application.getRunnerPool().getRunningJobManager()
                            .out(jobWrapper.getJobId());
                }
                // ͳ������

                jobWrapper = callback.runComplete(response);
            }
        } finally {

        }
    }



}
