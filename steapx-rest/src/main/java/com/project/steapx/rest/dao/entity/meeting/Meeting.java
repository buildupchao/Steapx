package com.project.steapx.rest.dao.entity.meeting;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Meeting implements Serializable {

	private static final long serialVersionUID = 7646733414987793556L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meeting_id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "meeting_name", nullable = false)
	private String meetingName;
	
	@Column(name = "meeting_time", nullable = false)
	private Timestamp meetingTime;
	
	@Column(name = "meeting_place", nullable = false)
	private String meetingPlace;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@Column(name = "host_id", nullable = false)
	private Integer hostId;
	
	@Column(name = "remark")
	private String remark;

}
