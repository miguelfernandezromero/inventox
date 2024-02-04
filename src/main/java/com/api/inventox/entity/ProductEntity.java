package com.api.inventox.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTO")
public class ProductEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="NOMBRE_PRODUCTO")
	private String nameProduct;
	
	@Column(name="DESCRIPCION_PRODUCTO")
	private String description;
	
	@Column(name="CODIGO_BARRAS")
	private String barcode;
	
	@Column(name="CODIGO_NUMERICO")
	private String codeNumber;

	@Column(name="PRECIO_COMPRA")
	private BigDecimal purchaseValue;
	
	@Column(name="PRECIO_VENTA")
	private BigDecimal saleValue;
	
	@Column(name="FECHA_ENTRADA")
	private Date entryDate;
	
	@Column(name="FECHA_SALIDA")
	private Date departureDate;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID")
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "MARCA_ID")
	private BrandEntity brand;

	@OneToMany(mappedBy = "product")
    private List<StockEntity> stocks;
	
}
