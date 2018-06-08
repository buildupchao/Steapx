package com.project.steapx.common.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EUTreeNode implements Serializable {
    private static final long serialVersionUID = 4988057146708605881L;

    private Long id;
    private String text;
    private String state;
}
