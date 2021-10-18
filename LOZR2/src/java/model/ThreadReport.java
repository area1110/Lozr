/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author area1
 */
public class ThreadReport {
    private int reportID;
    private FThread thread;

    public ThreadReport() {
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public FThread getThread() {
        return thread;
    }

    public void setThread(FThread thread) {
        this.thread = thread;
    }
    
    
}
