package me.j360.jdk.application.remote;



import me.j360.jdk.application.remote.exception.RemotingCommandFieldCheckException;

import java.io.Serializable;

/**
 * RemotingCommand���Զ����ֶη������Ĺ����ӿ�
 */
public interface RemotingCommandBody extends Serializable {

    public void checkFields() throws RemotingCommandFieldCheckException;
}
