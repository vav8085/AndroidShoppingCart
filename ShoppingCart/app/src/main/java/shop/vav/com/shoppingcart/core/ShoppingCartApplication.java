package shop.vav.com.shoppingcart.core;

import android.app.Application;

import shop.vav.com.shoppingcart.core.dagger.AppComponent;
import shop.vav.com.shoppingcart.core.dagger.AppModule;
import shop.vav.com.shoppingcart.core.dagger.DaggerAppComponent;

/**
 * Created by Vaibhav on 12/6/2017.
 */

public class ShoppingCartApplication extends Application {
    private static AppComponent appComponent;
    private static ShoppingCartApplication instance = new ShoppingCartApplication();

    @Override
    public void onCreate() {
        super.onCreate();
         getAppComponent();
    }

    public static ShoppingCartApplication getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        if(appComponent==null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}
