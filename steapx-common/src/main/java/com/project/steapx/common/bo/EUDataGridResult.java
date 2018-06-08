package com.project.steapx.common.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EUDataGridResult implements Serializable {
	private static final long serialVersionUID = -8815289096591290575L;
	
	private long total;
    private List<?> rows;
}
