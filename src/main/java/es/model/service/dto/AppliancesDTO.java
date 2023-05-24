package es.model.service.dto;

import java.util.ArrayList;
import java.util.List;

import es.model.domain.Appliances;
import es.model.domain.ProductImage;
import es.model.domain.State;
import es.model.repository.AppliancesRepository.AppliancesProjection;

public class AppliancesDTO {

	private Long id;
	private String name;
	private String description;
	private State state;
	private UserDTO owner;
	private Double price;
	private boolean isFavourite;
	private ProductOwner productOwner;
	private ProductImageDTO images;

	public AppliancesDTO() {
	}

	public AppliancesDTO(AppliancesProjection product) {
		this(product.getAppliances());
		this.isFavourite = product.getIsFavourite();
	}

	public AppliancesDTO(Appliances appliances) {
		this.id = appliances.getId();
		this.name = appliances.getName();
		this.description = appliances.getDescription();
		this.state = appliances.getState();
		this.price = appliances.getPrice();
		if (appliances.getImages() != null && !appliances.getImages().isEmpty()) {
			this.images = new ProductImageDTO(appliances.getImages().get(0));
		}
		this.productOwner = new ProductOwner(appliances.getOwner().getId(), appliances.getOwner().getName(),
				appliances.getOwner().getSurname());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public UserDTO getOwner() {
		return owner;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public List<ProductImage> getImages() {
		List<ProductImage> list = new ArrayList<ProductImage>();
		if (images != null)
			list.add(images.toProduct());
		return list;
	}

	public void setImages(ProductImageDTO productImages) {
		this.images = productImages;
	}

	public Appliances toAppliances() {
		Appliances appliances = new Appliances();
		appliances.setId(this.getId());
		appliances.setName(this.getName());
		appliances.setDescription(this.getDescription());
		appliances.setState(this.getState());
		appliances.setPrice(this.getPrice());
		appliances.setImages(this.getImages());

		return appliances;
	}

	public ProductOwner getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(ProductOwner productOwner) {
		this.productOwner = productOwner;
	}
}
