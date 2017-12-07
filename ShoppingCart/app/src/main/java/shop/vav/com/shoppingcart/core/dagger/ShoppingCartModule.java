package shop.vav.com.shoppingcart.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shop.vav.com.shoppingcart.common.ShoppingCart;

/**
 * Created by Vaibhav on 12/6/2017.
 */
@Module
public class ShoppingCartModule {
    @Provides @Singleton
    ShoppingCart provideShoppingCart(SharedPreferences preferences){
        return new ShoppingCart(preferences);
    }
    @Provides @Singleton
    SharedPreferences provideSharedPreferences (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
