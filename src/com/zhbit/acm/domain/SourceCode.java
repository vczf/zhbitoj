package com.zhbit.acm.domain;

/**
 * Created by Cyril on 16/6/5.
 */
public class SourceCode {
    private int solutionId;
    private String source;
    private boolean isDelete;

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
