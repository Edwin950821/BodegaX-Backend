package com.edwin.bodega_x.repository

import com.edwin.bodega_x.model.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository("producto.repository")
interface ProductoRepository: JpaRepository<Producto,UUID>, JpaSpecificationExecutor<Producto>  {

}