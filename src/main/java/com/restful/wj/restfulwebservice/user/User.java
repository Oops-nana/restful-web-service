package com.restful.wj.restfulwebservice.user;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min=2, message = "Name은 최소 2글자 이상 입력해주세요.")//최소 2글자
    private String name;

    private String password;
    private String ssn;

    @Past() //과거에만 올 수 있다는 제약
    private Date joinDate;

}

