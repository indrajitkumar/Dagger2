package com.dagger.app

import com.dagger.app.dagger.DaggerCarMakerComponent
import com.dagger.app.vehicle.BadCar
import com.dagger.app.vehicle.GoodCar
import com.dagger.app.vehicle.WeirdCar
import com.dagger.app.vehicle.gear.ManualGear
import com.dagger.app.vehicle.engine.Fuel
import com.dagger.app.vehicle.engine.FuelQuality
import com.dagger.app.vehicle.engine.GoodEngine
import com.dagger.app.vehicle.engine.GoodFuelInjector

fun main(args: Array<String>) {
    noDependencyInjection()

    manualDependencyInjection()

    daggerConstructorInjection()

    daggerFieldInjection()
}

fun noDependencyInjection(){
    val badCar = BadCar()
    badCar.drive()
}

fun daggerConstructorInjection(){
    val normalCar = DaggerCarMakerComponent.builder().build().normalCar()
    normalCar.drive()
}

fun daggerFieldInjection(){
    val weirdCar = WeirdCar()
    DaggerCarMakerComponent.builder()
            .build()
            .weirdCar(weirdCar)
    weirdCar.drive()
}

fun manualDependencyInjection(){
    val fuel = Fuel("Audi", FuelQuality.GOOD, 100)
    val goodFuelInjector = GoodFuelInjector(fuel)
    val goodEngine = GoodEngine(goodFuelInjector)
    val manualGear = ManualGear()
    val goodCar = GoodCar(goodEngine, manualGear)
    goodCar.drive()
}