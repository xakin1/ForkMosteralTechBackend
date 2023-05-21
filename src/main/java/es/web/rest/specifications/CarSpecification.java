package es.web.rest.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;
import javax.persistence.criteria.Path;

import es.model.domain.Car;
import es.web.rest.util.specification_utils.SpecificationUtil;

public class CarSpecification {
  public static Specification<Car> searchAll(String search) {
    return new Specification<Car>() {
      @Override
      public Predicate toPredicate(
          Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        String stringToFind = ("%" + search + "%").toLowerCase();
        Path path = SpecificationUtil.getPath(root, null);
        predicates.add(
            criteriaBuilder.like(
                criteriaBuilder.lower(path.get("id").as(String.class)), stringToFind));
        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
      }
    };
  }
}
