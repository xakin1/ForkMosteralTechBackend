package es.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import es.model.domain.State;
import es.model.service.dto.AppliancesDTO;
import es.model.service.dto.AppliancesFullDTO;
import es.model.service.exceptions.NotFoundException;
import es.model.service.exceptions.OperationNotAllowedException;

public interface AppliancesService {

  Page<AppliancesDTO> getAll(Pageable pageable, List<String> filters, String search);

  Page<AppliancesDTO> getAllAppliancesWithFavourites(
      String userId, Pageable pageable, Double minPrice, Double maxPrice, State state)
      throws NotFoundException;

  AppliancesFullDTO get(Long id) throws NotFoundException;

  AppliancesFullDTO create(AppliancesFullDTO appliances) throws OperationNotAllowedException;

  AppliancesFullDTO update(Long id, AppliancesFullDTO appliances)
      throws OperationNotAllowedException;

  void delete(Long id);
}
