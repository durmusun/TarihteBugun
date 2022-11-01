package com.appkolik.tarihtebugun.domain.use_case

import com.appkolik.tarihtebugun.data.remote.dto.toHistory
import com.appkolik.tarihtebugun.domain.model.History
import com.appkolik.tarihtebugun.domain.repository.TodayHistoryRepository
import com.appkolik.tarihtebugun.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllHistoryUseCase @Inject constructor(
    private val repository: TodayHistoryRepository
) {

    operator fun invoke(): Flow<Resource<History>> = flow {

        try {
            emit(Resource.Loading(message = "..."))
            val history: History = repository.getHistory().toHistory()
            emit(Resource.Success(history, "Yükleme Tamamlandı"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Bilinmeyen Bir Hata Oluştu."))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "İnternet Bağlantınızı Kontrol Edin."
                )
            )
        }

    }

}