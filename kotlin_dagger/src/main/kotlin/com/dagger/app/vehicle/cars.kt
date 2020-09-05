package com.dagger.app.vehicle

import com.dagger.app.vehicle.engine.BadEngine
import com.dagger.app.vehicle.engine.Engine
import com.dagger.app.vehicle.gear.Gear
import com.dagger.app.vehicle.gear.ManualGear
import javax.inject.Inject
import javax.inject.Named

interface Car {
    fun drive()
}

class BadCar : Car {
    val engine = BadEngine()
    val gear = ManualGear()

    override fun drive() {
        println("\n${this.javaClass.simpleName} with ${gear.javaClass.simpleName} gear: ")
        println(engine.start())
    }
}

class GoodCar @Inject constructor(val engine: Engine, val gear: Gear) : Car {
    override fun drive() {
        println("\n${this.javaClass.simpleName} with ${gear.javaClass.simpleName} gear: ")
        println(engine.start())
    }
}

class WeirdCar : Car {
    @Inject lateinit var engine: Engine
    @Inject @field:Named("manual") lateinit var gear: Gear

    override fun drive() {
        println("\n${this.javaClass.simpleName} with ${gear.javaClass.simpleName} gear: ")
        println(engine?.start())
    }
}

