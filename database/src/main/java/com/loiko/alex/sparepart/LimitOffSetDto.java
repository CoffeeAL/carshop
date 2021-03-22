package com.loiko.alex.sparepart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LimitOffSetDto {

    private Integer limit;
    private Integer offset;
}