package org.example.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
//无参构造函数
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptNo;
    private String deptName;
    private String dbSource;
}
