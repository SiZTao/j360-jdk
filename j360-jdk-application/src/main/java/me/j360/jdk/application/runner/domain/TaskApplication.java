package me.j360.jdk.application.runner.domain;


import me.j360.jdk.application.core.common.constant.Level;
import me.j360.jdk.application.core.common.support.Application;
import me.j360.jdk.application.runner.RunnerFactory;
import me.j360.jdk.application.runner.RunnerPool;
import me.j360.jdk.application.runner.support.JobPullMachine;

public class TaskApplication extends Application {

    // runner �̳߳�
    private RunnerPool runnerPool;
    //
    private RunnerFactory runnerFactory;
    // Pull Job Machine
    private JobPullMachine jobPullMachine;
    /**
     * ҵ����־��¼����
     */
    private Level bizLogLevel;
    /**
     * ִ�������class
     */
    private Class jobRunnerClass;


    public RunnerPool getRunnerPool() {
        return runnerPool;
    }

    public void setRunnerPool(RunnerPool runnerPool) {
        this.runnerPool = runnerPool;
    }

    public Level getBizLogLevel() {
        return bizLogLevel;
    }

    public void setBizLogLevel(Level bizLogLevel) {
        this.bizLogLevel = bizLogLevel;
    }

    public Class getJobRunnerClass() {
        return jobRunnerClass;
    }

    public void setJobRunnerClass(Class jobRunnerClass) {
        this.jobRunnerClass = jobRunnerClass;
    }

    public RunnerFactory getRunnerFactory() {
        return runnerFactory;
    }

    public void setRunnerFactory(RunnerFactory runnerFactory) {
        this.runnerFactory = runnerFactory;
    }

    public JobPullMachine getJobPullMachine() {
        return jobPullMachine;
    }

    public void setJobPullMachine(JobPullMachine jobPullMachine) {
        this.jobPullMachine = jobPullMachine;
    }

}