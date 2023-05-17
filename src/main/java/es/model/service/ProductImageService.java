package es.model.service;

import es.model.service.dto.ProductImageDTO;
import es.model.service.dto.ProductImageFullDTO;
import es.model.service.exceptions.NotFoundException;
import es.model.service.exceptions.OperationNotAllowedException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductImageService {

  Page<ProductImageDTO> getAll(Pageable pageable, List<String> filters, String search);

  ProductImageFullDTO get(Long id) throws NotFoundException;

  Page<ProductImageDTO> getByProductId(Long id, Pageable page) throws NotFoundException;

  ProductImageFullDTO create(ProductImageFullDTO productImage) throws OperationNotAllowedException;

  ProductImageFullDTO update(Long id, ProductImageFullDTO productImage)
      throws OperationNotAllowedException;

  void delete(Long id);
}
