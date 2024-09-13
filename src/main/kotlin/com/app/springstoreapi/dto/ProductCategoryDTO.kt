package com.app.springstoreapi.dto

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ProductCategoryDTO(
    val id: Long,
    val productName: String,
    val unitPrice: BigDecimal,
    val unitStock: Int?,
    val productPicture: String?,
    val categoryId: Long,
    val categoryName: String?,
    val createDate: String,
    val modifiedDate: String?

) {
    companion object {
        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        // ฟังก์ชันเพื่อสร้าง ProductCategoryDTO จาก Entity
        fun fromEntity(
            id: Long,
            productName: String,
            unitPrice: BigDecimal,
            unitStock: Int?,
            productPicture: String?,
            categoryId: Long,
            categoryName: String?,
            createDate: LocalDateTime,
            modifiedDate: LocalDateTime?
        ): ProductCategoryDTO {
            return ProductCategoryDTO(
                id = id,
                productName = productName,
                unitPrice = unitPrice,
                unitStock = unitStock,
                productPicture = productPicture,
                categoryId = categoryId,
                categoryName = categoryName,
                createDate = createDate.format(formatter),
                modifiedDate = modifiedDate?.format(formatter)
            )
        }
    }

    // เพิ่ม constructor เดิมที่ใช้โดย JPQL
    constructor(
        id: Long,
        productName: String,
        unitPrice: BigDecimal,
        unitStock: Int?,
        productPicture: String?,
        categoryId: Long,
        categoryName: String?,
        createDate: LocalDateTime,
        modifiedDate: LocalDateTime?
    ) : this(
        id,
        productName,
        unitPrice,
        unitStock,
        productPicture,
        categoryId,
        categoryName,
        createDate.format(formatter),
        modifiedDate?.format(formatter)
    )
}

