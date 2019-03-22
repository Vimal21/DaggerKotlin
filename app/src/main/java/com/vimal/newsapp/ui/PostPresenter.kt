package com.vimal.newsapp.ui

import com.vimal.newsapp.R
import com.vimal.newsapp.base.BasePresenter
import com.vimal.newsapp.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostPresenter(postView: PostView) : BasePresenter<PostView>(postView) {
    @Inject
    lateinit var postApi: PostApi

    private var subscription : Disposable? = null

    override fun onViewCreated(){
        loadPosts()
    }

    fun loadPosts(){
        view.showLoading()
        subscription = postApi.
                        getPosts().
                            observeOn(AndroidSchedulers.mainThread()).
                            subscribeOn(Schedulers.io()).
                            doOnTerminate{view.hideLoading()}.
                            subscribe({
                                postList -> view.updatePosts(postList)
                            },{
                                view.showError(R.string.app_name)
                            })

    }

    override fun onViewDestroyed(){
        subscription?.dispose()
    }
}