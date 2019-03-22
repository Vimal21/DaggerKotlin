package com.vimal.newsapp.base

import com.vimal.newsapp.di.component.DaggerPresenterInjector
import com.vimal.newsapp.di.component.PresenterInjector
import com.vimal.newsapp.di.module.ContextModule
import com.vimal.newsapp.di.module.NetworkModule
import com.vimal.newsapp.ui.PostPresenter

abstract class BasePresenter <out V : BaseView>(protected val view: V) {

    private val injector : PresenterInjector = DaggerPresenterInjector.
                                            builder().
                                            contextModule(ContextModule).
                                            networkModule(NetworkModule).
                                            baseView(view).
                                            build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    private fun inject(){
        when (this){
            is PostPresenter -> injector.inject(this)
        }
    }
}