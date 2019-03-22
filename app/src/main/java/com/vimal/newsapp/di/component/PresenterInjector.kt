package com.vimal.newsapp.di.component

import com.vimal.newsapp.base.BaseView
import com.vimal.newsapp.di.module.ContextModule
import com.vimal.newsapp.di.module.NetworkModule
import com.vimal.newsapp.ui.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class),(NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter : PostPresenter)

    @Component.Builder
    interface Builder{
        fun build() : PresenterInjector

        fun networkModule(networkModule : NetworkModule) : Builder
        fun contextModule(contextModule : ContextModule) : Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}