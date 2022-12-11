package com.droi.domain.usecase

import com.droi.domain.model.YoEntity
import com.droi.domain.repository.YoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetUserUseCase (private val repository: YoRepository) {

//    suspend fun invoke(q:String): YoEntity.Res {
//        return repository.getUsers(q)
//    }
    operator fun invoke(
        q:String,
        scope: CoroutineScope,
        onResult : (YoEntity.Res)-> Unit ={},
    ){
        scope.launch (Dispatchers.Main){
            val deferred = async (Dispatchers.IO){
                repository.getUsers(q)
            }
            onResult(deferred.await())
        }

    }
}