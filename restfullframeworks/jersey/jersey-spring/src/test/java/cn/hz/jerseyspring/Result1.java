package cn.hz.jerseyspring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
/**
 * 服务结果基类
 * @author alex.zhu
 *
 * @param <T>
 */
@XmlAccessorType(XmlAccessType.NONE)
abstract public class Result1<T> {
    public final static String ROOT_ELEMENT = "result";

    public enum Status {
        OK("ok"), Error("error");

        private Status(String message) {
            _message = message;
        }

        @Override
        public String toString() {
            return _message;
        }

        private String _message;
    }

    //

    // to prevent jaxb exception
    protected Result1() {
    }

    protected Result1(T payload) {
        _payload = payload;
    }

    @XmlAttribute(name = "status")
    public String getStatusName() {
        return _status.toString();
    }

    protected Status getStatus() {
        return _status;
    }

    protected void setStatus(Status value) {
        _status = value;
    }
        
    protected T getPayload() {
        return _payload;
    }

    protected void setPayload(T value) {
        _payload = value;
    }

    private T _payload;
    private Status _status = Status.OK;
}
