package com.isbing.springsecurity.entity;

import com.isbing.springsecurity.utils.MyDateUtil;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by songbing
 * Created time 2019/3/17 上午11:30
 */
@MappedSuperclass
@Data
@Deprecated
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -6718838800112233445L;

    @Id
    @Column(length = 32, nullable = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String id;// ID

    @DateTimeFormat(pattern = MyDateUtil.DEFAULT_DATETIME_FORMAT)
    public Date createTime;// 创建日期

    @DateTimeFormat(pattern = MyDateUtil.DEFAULT_DATETIME_FORMAT)
    public Date modifyTime = new Date();// 修改日期

}
