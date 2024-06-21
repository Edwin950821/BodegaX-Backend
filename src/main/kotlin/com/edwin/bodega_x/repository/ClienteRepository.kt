package com.edwin.bodega_x.repository

import com.edwin.bodega_x.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository("cliente.repository")
interface ClienteRepository: JpaRepository<Cliente,UUID>, JpaSpecificationExecutor<Cliente>  {

}