package mz.co.exchangerate.exchangeapi.history.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCreateDTO {
    @NotBlank(message = "History Rate ID")
    private Integer rate;
}
