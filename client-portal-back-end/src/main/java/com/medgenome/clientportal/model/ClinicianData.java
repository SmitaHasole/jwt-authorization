package com.medgenome.clientportal.model;

import java.util.Date;

/**
 * created by Smita Hasole on 10-04-2018
 */

public class ClinicianData {
    String orderID;
    Date orderDate;
    Date sampleReceivedDate;
    String patientName;
    String testName;
    String status;
    String TAT;
    boolean isReportReady;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getSampleReceivedDate() {
        return sampleReceivedDate;
    }

    public void setSampleReceivedDate(Date sampleReceivedDate) {
        this.sampleReceivedDate = sampleReceivedDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTAT() {
        return TAT;
    }

    public void setTAT(String TAT) {
        this.TAT = TAT;
    }

    public boolean isReportReady() {
        return isReportReady;
    }

    public void setReportReady(boolean reportReady) {
        isReportReady = reportReady;
    }
}
