package com.wl.base.exception;

/**
 * Created by wangliang on 16-12-19.
 */
public class GlobalException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2332608236621015980L;

    private String code;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String code, String message) {
        super(message);
        this.code = code;
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
