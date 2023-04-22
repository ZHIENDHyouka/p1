package com.p1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Manager {
    private Integer managerId;
    private String managerAc;
    private String managerPwd;
}
