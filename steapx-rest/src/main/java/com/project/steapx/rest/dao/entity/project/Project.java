package com.project.steapx.rest.dao.entity.project;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Project implements Serializable {

	private static final long serialVersionUID = -7483477814483093670L;
	
	@Id
	@Column(name = "project_id", nullable = false, unique = true)
	private String id;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "applicant", nullable = false)
	private String applicant;

	@Column(name = "application_date", nullable = false)
	private Timestamp applicationDate;

	@Column(name = "end_date", nullable = false)
	private Timestamp endDate;

	@Column(name = "contact_person", nullable = false)
	private String contactPerson;
	
	@Column(name = "telephone", nullable = false)
	private String telephone;

	@Column(name = "domain", nullable = false)
	private String domain;

	@Column(name = "project_funds", precision = 19, scale = 4, nullable = false)
	private BigDecimal projectFunds;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "certificate", nullable = false)
	private Boolean certificate;

	@Column(name = "record_person", nullable = false)
	private String recordPerson;

	@Column(name = "remark")
	private String remark;
}
