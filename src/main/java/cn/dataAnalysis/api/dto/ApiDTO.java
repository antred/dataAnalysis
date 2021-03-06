package cn.dataAnalysis.api.dto;

/**
 * Created by msi on 2017/6/29.
 */
public class ApiDTO<T> {

    private   int errNum;
    private   String errMsg;
    private    T  retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }
}
