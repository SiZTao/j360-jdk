package me.j360.jdk.application.test.runner;


import me.j360.jdk.application.core.common.support.Job;
import me.j360.jdk.application.runner.Action;
import me.j360.jdk.application.runner.JobRunner;
import me.j360.jdk.application.runner.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJobRunner implements JobRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestJobRunner.class);

    @Override
    public Result run(Job job) throws Throwable {
        try {
//            Thread.sleep(1000L);
//
//            if (job.getRetryTimes() > 5) {
//                return new Result(Action.EXECUTE_FAILED, "���Դ�������5���ˣ��Ź����!");
//            }
//
//            if (SystemClock.now() % 2 == 1) {
//                return new Result(Action.EXECUTE_LATER, "�Ժ�ִ��");
//            }

            // TODO ҵ���߼�
            LOGGER.info("��Ҫִ�У�" + job);
            // �ᷢ�͵� LTS (JobTracker��)
            //bizLogger.info("���ԣ�ҵ����־����������");

        } catch (Exception e) {
            LOGGER.info("Run job failed!", e);
            return new Result(Action.EXECUTE_FAILED, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "ִ�гɹ��ˣ�����");
    }
}
