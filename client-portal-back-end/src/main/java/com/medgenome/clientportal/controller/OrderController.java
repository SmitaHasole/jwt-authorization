package com.medgenome.clientportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medgenome.clientportal.model.Clinician;
import com.medgenome.clientportal.model.Patient;

@RestController
@RequestMapping("/")
public class OrderController {

	@RequestMapping(value = "/clinician/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Clinician>> getClinicianOrders(@PathVariable("id") String id) throws IOException {
		List<Clinician> list = new ArrayList<>();
		Clinician c1 = new Clinician();
		c1.setOrderDate(new Date());
		c1.setOrderID("1");
		c1.setPatientName("abc");
		c1.setReportReady(true);
		c1.setSampleReceivedDate(new Date());
		c1.setStatus("ReportReady");
		c1.setTat("4");
		c1.setTestName("test1");

		Clinician c2 = new Clinician();
		c2.setOrderDate(new Date());
		c2.setOrderID("2");
		c2.setPatientName("abc1");
		c2.setReportReady(false);
		c2.setSampleReceivedDate(new Date());
		c2.setStatus("ReportNotReady");
		c2.setTat("4");
		c2.setTestName("test2");

		list.add(c1);
		list.add(c2);

		ResponseEntity<List<Clinician>> response = new ResponseEntity<List<Clinician>>(list, HttpStatus.OK);
		return response;

	}

	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Patient>> getPatientOrders(@PathVariable("id") String id) throws IOException {
		List<Patient> list = new ArrayList<>();
		Patient p1 = new Patient();
		p1.setOrderDate(new Date());
		p1.setOrderID("1");
		p1.setHospitalName("hosp1");
		p1.setReportReady(true);
		p1.setSampleReceivedDate(new Date());
		p1.setStatus("ReportReady");
		p1.setPaymentDone(true);
		p1.setTestName("test1");
		p1.setPhysician("c1");
		p1.setPendingAmount(0l);

		Patient p2 = new Patient();
		p2.setOrderDate(new Date());
		p2.setOrderID("2");
		p2.setHospitalName("hosp" +
				"2");
		p2.setReportReady(false);
		p2.setSampleReceivedDate(new Date());
		p2.setStatus("ReportnotReady");
		p2.setPaymentDone(false);
		p2.setTestName("test2");
		p2.setPhysician("c2");
		p2.setPendingAmount(100l);

		list.add(p1);
		list.add(p2);

		ResponseEntity<List<Patient>> response = new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		return response;

	}

}
