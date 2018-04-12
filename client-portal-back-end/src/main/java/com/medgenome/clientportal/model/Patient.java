package com.medgenome.clientportal.model;

import java.util.Date;

/**
 * created by Smita Hasole on 10-04-2018
 */

public class Patient {
	String orderID;
	Date orderDate;
	Date sampleReceivedDate;
	String physician;
	String hospitalName;
	String testName;
	String status;
	Long pendingAmount;
	boolean isPaymentDone;
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

	public String getPhysician() {
		return physician;
	}

	public void setPhysician(String physician) {
		this.physician = physician;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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

	public Long getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Long pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public boolean isPaymentDone() {
		return isPaymentDone;
	}

	public void setPaymentDone(boolean paymentDone) {
		isPaymentDone = paymentDone;
	}

	public boolean isReportReady() {
		return isReportReady;
	}

	public void setReportReady(boolean reportReady) {
		isReportReady = reportReady;
	}
}
