package com.cj.domain.dto;

import com.cj.vaildGroup.GroupFirst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YyDyw {
    @NotNull(message = "用户不得为空",groups = GroupFirst.class)
    private Integer userId;
    @NotNull(message = "金额不得为空",groups = GroupFirst.class)
    private BigDecimal amountMoney;
    @NotBlank(message = "名字不得为空",groups ={GroupFirst.class, Default.class})
    private String name;

}
