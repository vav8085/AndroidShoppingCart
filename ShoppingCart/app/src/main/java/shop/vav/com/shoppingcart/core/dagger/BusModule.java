package shop.vav.com.shoppingcart.core.dagger;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vaibhav on 12/7/17.
 */
@Module
public class BusModule {

    @Provides @Singleton
    public Bus provideBus(){
        return new Bus();
    }
}
