package br.com.msena.myappcommerce.model

data class Product(
    val id : String,
    val title :String,
    val category : ProductCategory,
    val description : String,
    val price : Double,
    val colors : List<ProductColor>,
    val sizes : List<ProductSize>,
    val images: List<ProductImage>

)