package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.common.network.ApiGenerator
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenText
import com.mredrock.cyxbs.freshman.config.API_BASE_IMG_URL
import com.mredrock.cyxbs.freshman.interfaces.model.IActivityCampusGuidelinesModel
import com.mredrock.cyxbs.freshman.interfaces.network.DormitoryAndCanteenService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ActivityCampusGuidelinesModel : BaseModel(), IActivityCampusGuidelinesModel {
    override fun requestDormitoryAndCanteen(callback: (List<DormitoryAndCanteenText>) -> Unit) {
        val service = ApiGenerator.getApiService(DormitoryAndCanteenService::class.java)
        service.requestDormitoryAndCanteen()
                .subscribeOn(Schedulers.io())
                .map {dormitoryAndCanteenBean ->
                    dormitoryAndCanteenBean.text.forEach { text ->
                        text.message.forEach { message ->
                            message.photo = message.photo.map { "$API_BASE_IMG_URL$it" }
                        }
                    }
                    dormitoryAndCanteenBean.text
                }
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribeBy { callback(it) }
    }
}