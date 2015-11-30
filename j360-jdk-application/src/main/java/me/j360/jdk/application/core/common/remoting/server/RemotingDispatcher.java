package me.j360.jdk.application.core.common.remoting.server;

import me.j360.jdk.application.core.common.remoting.AbstractRemotingProcessor;
import me.j360.jdk.application.core.common.support.Application;
import me.j360.jdk.application.remote.Channel;
import me.j360.jdk.application.remote.RemotingProcessor;
import me.j360.jdk.application.remote.exception.RemotingCommandException;
import me.j360.jdk.application.remote.job.NodeType;
import me.j360.jdk.application.remote.protocol.AbstractRemotingCommandBody;
import me.j360.jdk.application.remote.protocol.JobProtos;
import me.j360.jdk.application.remote.protocol.JobProtos.RequestCode;
import me.j360.jdk.application.remote.protocol.RemotingCommand;
import me.j360.jdk.application.remote.protocol.RemotingProtos;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Robert HG (254963746@qq.com) on 7/23/14.
 *         job tracker �ܵĴ�����, ÿһ�������Ӧ��ͬ�Ĵ�����
 */
public class RemotingDispatcher extends AbstractRemotingProcessor {

    private final Map<RequestCode, RemotingProcessor> processors = new HashMap<RequestCode, RemotingProcessor>();

    public RemotingDispatcher(Application application) {
        super(application);
    }

    @Override
    public RemotingCommand processRequest(Channel channel, RemotingCommand request) throws RemotingCommandException {
        // ����
        if (request.getCode() == JobProtos.RequestCode.HEART_BEAT.code()) {
            commonHandler(channel, request);
            return RemotingCommand.createResponseCommand(JobProtos.ResponseCode.HEART_BEAT_SUCCESS.code(), "");
        }

        // ����������code
        RequestCode code = RequestCode.valueOf(request.getCode());
        RemotingProcessor processor = processors.get(code);
        if (processor == null) {
            return RemotingCommand.createResponseCommand(RemotingProtos.ResponseCode.REQUEST_CODE_NOT_SUPPORTED.code(), "request code not supported!");
        }
        commonHandler(channel, request);
        return processor.processRequest(channel, request);
    }

    /**
     * 1. �� channel ���������(�����ھͼ���)
     * 2. ���� TaskTracker �ڵ���Ϣ(�����߳���)
     */
    private void commonHandler(Channel channel, RemotingCommand request) {
        AbstractRemotingCommandBody commandBody = request.getBody();
        String nodeGroup = commandBody.getNodeGroup();
        String identity = commandBody.getIdentity();
        NodeType nodeType = NodeType.valueOf(commandBody.getNodeType());

        // 1. �� channel ���������(�����ھͼ���)
        //application.getChannelManager().offerChannel(new ChannelWrapper(channel, nodeType, nodeGroup, identity));
    }

}
