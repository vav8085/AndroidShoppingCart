package shop.vav.com.shoppingcart.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shop.vav.com.shoppingcart.core.ShoppingCartApplication;

/**
 * Created by vaibhav on 8/26/17.
 */
@Module
public class AppModule {
    private final ShoppingCartApplication app;

    public AppModule(ShoppingCartApplication app) {
        this.app = app;
    }
    @Provides @Singleton
    public Context provideContext(){
        return app;
    }
    @Provides @Singleton
    public ShoppingCartApplication provideApp(){
        return app;
    }
}
