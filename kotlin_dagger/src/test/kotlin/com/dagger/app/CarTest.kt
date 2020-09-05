package com.dagger.app

import org.junit.Test
import org.junit.Assert.assertEquals
import com.dagger.app.vehicle.engine.FuelInjector
import com.dagger.app.vehicle.engine.GoodEngine

class FakeFuelInjector(private val fakeFuel:Int): FuelInjector {
    override fun injectFuel(): Int {
        return fakeFuel
    }
}

class CarTest {
    @Test
    fun testEngine(){
        val fakeFuelEngine1 = FakeFuelInjector(90)
        val engine = GoodEngine(fakeFuelEngine1)
        assertEquals("Starting Engine: It can travel " +
                "very very fast and far", engine.start())
    }
}
