package com.vector.cronoapp.repository

import com.vector.cronoapp.model.Cronos
import com.vector.cronoapp.room.CronosDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class CronosRepository @Inject constructor( private val cronosDao: CronosDatabaseDao) {
    suspend fun addCronos(cronos: Cronos) = cronosDao.insert(cronos)
    suspend fun updateCronos(cronos:Cronos) = cronosDao.update(cronos)
    suspend fun deleteCronos(cronos: Cronos) = cronosDao.delete(cronos)
    fun getAllCronos(): Flow<List<Cronos>> = cronosDao.getCronos().flowOn(Dispatchers.IO).conflate()
    fun getCronosById(id: Long): Flow<Cronos> = cronosDao.getCronosById(id).flowOn(Dispatchers.IO).conflate()

}