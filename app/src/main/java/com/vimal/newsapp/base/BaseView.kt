package com.vimal.newsapp.base

import android.content.Context

/**
 * Base View must be implemented
 */
interface BaseView{
    /**
     * Returns the Context in which the application is running
     * @return the Context in which the application is running
     */

    fun getContext() : Context
}