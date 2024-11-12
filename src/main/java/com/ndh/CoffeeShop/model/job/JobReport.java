package com.ndh.CoffeeShop.model.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ndh.CoffeeShop.model.BaseEntity;
import com.ndh.CoffeeShop.model.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "job_report")
public class JobReport extends BaseEntity {

    public static final String COL_USER_ID       = "user_id";
    public static final String COL_CODE          = "code";
    public static final String COL_DAY_OFF       = "day_off";
    public static final String COL_DAY_WORKED    = "day_worked";
    public static final String COL_DAY_REQUIRED  = "day_required";
    public static final String COL_STATUS        = "status";
    public static final String COL_DAY_LEAVE     = "day_leave";

    @Column(name = COL_DAY_OFF, nullable = true)
    private Double dayOff;

    @Column(name = COL_CODE, nullable = true)
    private String code;

    @Column(name = COL_DAY_WORKED, nullable = true)
    private Double dayWorked;

    @Column(name = COL_DAY_REQUIRED, nullable = true)
    private Double dayRequired;

    @Column(name = COL_STATUS, nullable = true)
    private Integer status;

    @Column(name = COL_DAY_LEAVE, nullable = true)
    private Double dayLeave;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_USER_ID, nullable = false)
    private User user;
}
