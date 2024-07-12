package com.edwin.bodega_x.service.admin

import com.edwin.bodega_x.dto.LoginDto
import com.edwin.bodega_x.model.Admin
import java.util.UUID

interface AdminService {
    fun findAll(): List<Admin>
    fun findByUuid(uuid: UUID): Admin
    fun create(admin: Admin): Admin
    fun update(admin: Admin): Admin
    fun deleted(admin: Admin)

    fun login(login: LoginDto): Admin
}