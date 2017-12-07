package shop.vav.com.shoppingcart.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import shop.vav.com.shoppingcart.common.MainActivity;

/**
 * Created by vaibhav on 8/26/17.
 */
@Singleton
@Component(
    modules ={
            AppModule.class,ShoppingCartModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity activity);
}
