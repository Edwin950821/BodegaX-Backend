package com.edwin.bodega_x.repository

import com.edwin.bodega_x.model.Venta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository("venta.repository")
interface VentaRepository: JpaRepository<Venta,UUID>, JpaSpecificationExecutor<Venta>  {

}
