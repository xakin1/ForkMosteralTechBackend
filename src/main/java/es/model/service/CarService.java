package es.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import es.model.domain.State;
import es.model.service.dto.CarDTO;
import es.model.service.dto.CarFullDTO;
import es.model.service.exceptions.NotFoundException;
import es.model.service.exceptions.OperationNotAllowedException;

public interface CarService {

  Page<CarDTO> getAll(Pageable pageable, List<String> filters, String search);

  CarFullDTO get(Long id) throws NotFoundException;

  CarFullDTO create(CarFullDTO car) throws OperationNotAllowedException;

  CarFullDTO update(Long id, CarFullDTO car) throws OperationNotAllowedException;

  void delete(Long id);

  Page<CarDTO> getAllCarWithFavourites(
      String userId,
      Pageable pageable,
      Double minPrice,
      Double maxPrice,
      Integer minKm,
      Integer maxKm,
      State state)
      throws NotFoundException;
}
