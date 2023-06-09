package es.model.service.dto;

import java.util.ArrayList;
import java.util.List;

import es.model.domain.House;
import es.model.domain.ProductImage;
import es.model.domain.State;
import es.model.repository.HouseRepository.HouseProjection;

public class HouseDTO {

	private Long id;
	private String name;
	private String description;
	private int m2;
	private State state;
	private UserDTO owner;
	private Double price;
	private boolean isFavourite;
	private ProductOwner productOwner;
	private List<ProductImageDTO> images =  new ArrayList<>();

	public HouseDTO() {
	}

	public HouseDTO(HouseProjection product) {
		this(product.getProduct());
		this.isFavourite = product.getIsFavourite();
	}

	public HouseDTO(House house) {
		this.id = house.getId();
		this.name = house.getName();
		this.description = house.getDescription();
		this.state = house.getState();
		this.price = house.getPrice();
		this.m2 = house.getM2();
		if (house.getImages() != null && !house.getImages().isEmpty()) {
			this.images.add(new ProductImageDTO(house.getImages().get(0)));
		}
		this.productOwner = new ProductOwner(house.getOwner().getId(), house.getOwner().getName(),
				house.getOwner().getSurname());
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

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public List<ProductImageDTO> getImages() {
	    return images;
	}

	public void setImages(List<ProductImageDTO> images) {
	    this.images = images;
	}
	
	public List<ProductImage> getImagesProduct() {
	    List<ProductImage> imagesProduct = new ArrayList<>();
	    for (ProductImageDTO productImageDTO : this.images) {
	    	imagesProduct.add(productImageDTO.toProduct());
	    }
	    return imagesProduct;
	}
	
	public House toHouse() {
		House house = new House();
		house.setId(this.getId());
		house.setName(this.getName());
		house.setDescription(this.getDescription());
		house.setState(this.getState());
		house.setPrice(this.getPrice());
		house.setImages(this.getImagesProduct());
		house.setM2(this.getM2());
		return house;
	}

	public ProductOwner getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(ProductOwner productOwner) {
		this.productOwner = productOwner;
	}
}
