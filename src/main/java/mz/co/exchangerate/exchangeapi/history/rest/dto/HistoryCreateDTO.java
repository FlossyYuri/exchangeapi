package mz.co.exchangerate.exchangeapi.history.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCreateDTO {
    private Integer rate;
}
