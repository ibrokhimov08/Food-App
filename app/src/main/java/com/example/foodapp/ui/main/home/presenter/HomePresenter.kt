package com.example.foodapp.ui.main.home.presenter

import com.example.foodapp.BuildConfig
import com.example.foodapp.core.model.home.HomeResponse
import com.example.foodapp.core.network.ApiClient
import com.example.foodapp.core.network.service.HomeService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class HomePresenter(private val view: HomeMVP.View) : HomeMVP.Presenter {
    private var api: HomeService = ApiClient.createHomeService()
    private val disposable = CompositeDisposable()
    private var page = 0
    private val size = 20

    init {
        getFoods()
    }

    override fun getFoods() {
        val request1 = api.getFoodsWithPage(size, page, BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Response<HomeResponse>>() {
                override fun onSuccess(t: Response<HomeResponse>) {

                    if (t.isSuccessful) {
                        t.body()?.let {
                            view.setData(it)
                            page++
                        }
                    } else {
                        view.setError(t.message())
                    }
                }

                override fun onError(e: Throwable) {
                    view.setError(e.message.toString())

                }

            })
        disposable.add(request1)


    }

    override fun cencelRequest() {
        disposable.dispose()
    }


}