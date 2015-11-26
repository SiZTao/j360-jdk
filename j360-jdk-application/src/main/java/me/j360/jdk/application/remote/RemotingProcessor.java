package me.j360.jdk.application.remote;


import me.j360.jdk.application.remote.exception.RemotingCommandException;
import me.j360.jdk.application.remote.protocol.RemotingCommand;

/**
 * ����������������������ͻ���ͨ��
 */
public interface RemotingProcessor {
    public RemotingCommand processRequest(Channel channel, RemotingCommand request)
            throws RemotingCommandException;
}
