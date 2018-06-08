package com.project.steapx.rest.dao.entity.system;

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
public class SystemDictionary implements Serializable {

	private static final long serialVersionUID = 8133148410021426815L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dictionary_option_id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "dictionary_option_name", nullable = false, unique = true)
	private String dictionaryOptionName;
	
	@Column(name = "up_dictionary_option_id")
	private Integer upDictionaryOptionId;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "sort_no", nullable = false)
	private Integer sortNo;
	
	@Column(name = "english_name", nullable = false)
	private String englishName;
	
	@Column(name = "data_type", nullable = false)
	private String dataType;
	
	@Column(name = "entry_datetime", nullable = false)
	private Timestamp entryDateTime;
	
	@Column(name = "end_date")
	private Timestamp endDate;
	
	@Column(name = "remark")
	private String remark;
}
