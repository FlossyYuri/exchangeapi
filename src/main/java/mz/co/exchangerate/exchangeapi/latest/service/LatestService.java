package mz.co.exchangerate.exchangeapi.latest.service;


import mz.co.exchangerate.exchangeapi.latest.rest.dto.LatestResponseDTO;

public interface LatestService {
    LatestResponseDTO findByCode(String code);
}
