package com.sm.cn.exceptions;

import com.sm.cn.vo.ResultStatus;

public class LoginException extends RuntimeException {

    private ResultStatus resultStatus;

    public LoginException(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
