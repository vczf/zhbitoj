package com.zhbit.acm.domain;

/**
 * Created by Cyril on 16/6/5.
 */
public class Problem {
    private int problemId;
    private String title;
    private String description;
    private String input;
    private String output;
    private String sampleInput;
    private String sampleOutput;
    private String hint;
    private int timeLimit;
    private int memoryLimit;
    private int submit;
    private int solved;
    private int ac;
    private int pe;
    private int wa;
    private int re;
    private int tle;
    private int mle;
    private int ole;
    private int ce;
    private boolean hide;
    private boolean delete;
    private String source;

    public Problem(){}
    public Problem(int problemId,String title,int ac,int submit){
        this.problemId = problemId;
        this.title = title;
        this.ac = ac;
        this.submit = submit;
    }
    public Problem(int problemId,String title,int ac,int submit , boolean hide){
        this.problemId = problemId;
        this.title = title;
        this.ac = ac;
        this.submit = submit;
        this.hide=hide;
    }



    public boolean isHide() {
        return hide;
    }

    public boolean getHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean getDelete() {
        return delete;
    }

    public boolean isDelete(){
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getWa() {
        return wa;
    }

    public void setWa(int wa) {
        this.wa = wa;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public int getTle() {
        return tle;
    }

    public void setTle(int tle) {
        this.tle = tle;
    }

    public int getMle() {
        return mle;
    }

    public void setMle(int mle) {
        this.mle = mle;
    }

    public int getOle() {
        return ole;
    }

    public void setOle(int ole) {
        this.ole = ole;
    }

    public int getCe() {
        return ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }
}
