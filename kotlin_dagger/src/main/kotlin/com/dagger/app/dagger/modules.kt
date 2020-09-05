package com.dagger.app.dagger

import com.dagger.app.vehicle.Car
import com.dagger.app.vehicle.GoodCar
import com.dagger.app.vehicle.engine.*
import com.dagger.app.vehicle.gear.AutoGear
import com.dagger.app.vehicle.gear.Gear
import com.dagger.app.vehicle.gear.ManualGear
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class EngineModule {
    @Provides
    fun provideFuelInjector(@Named("NORMAL_FUEL") fuel: Fuel): FuelInjector {
        return GoodFuelInjector(fuel)
    }

    @Provides
    @Named("QUALITY_FUEL")
    fun provideQualityFuel(): Fuel {
        return Fuel("AudoQ5", FuelQuality.BEST, 100)
    }

    @Provides
    @Named("NORMAL_FUEL")
    fun provideBadFuel(): Fuel {
        return Fuel("AudiStandard", FuelQuality.NORMAL, 100)
    }


    @Provides
    fun provideEngine(fuelInjector: FuelInjector): Engine {
        return GoodEngine(fuelInjector)
    }
}

@Module
class GearModule {
    /**
     * Sometimes the type alone is insufficient to identify a dependency.
     * For example, a sophisticated car factory may want separate gears for the car.
     * In this case, we add a qualifier annotation.
     * This is any annotation that itself has a @Qualifier annotation.
     * Here’s the declaration of @Named, a qualifier annotation included in javax.inject:
     */
    @Provides
    @Named("auto")
    fun provideAutoGear(): Gear {
        return AutoGear()
    }

    @Provides
    @Named("manual")
    fun provideManualGear(): Gear {
        return ManualGear()
    }
}

@Module
class CarModule {
    @Provides
    fun provideAutoCar(engine: Engine, @Named("auto") gear: Gear): Car {
        return GoodCar(engine, gear)
    }
}