package osvaldo.app.news.mobile

import android.app.Application
import osvaldo.app.news.mobile.di.AppContainer
import osvaldo.app.news.mobile.di.AppContainerImpl

class NewsApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl()
    }

}