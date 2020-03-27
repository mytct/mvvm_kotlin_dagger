package com.tctmy363839.data.remote.service

import com.tctmy363839.data.remote.dto.NewsModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by AhmedEltaher on 5/12/2016
 */

interface NewsService {
    @GET("topstories/v2/home.json?api-key=4rfwOLzLTWd1a5xixcPjwddAhw3p0eiF")
    suspend fun fetchNews(): Response<NewsModel>
}
