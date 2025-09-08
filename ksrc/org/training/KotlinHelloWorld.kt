package org.training

import de.hybris.platform.servicelayer.user.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired


public open class KotlinHelloWorld (@param:Autowired val userService: UserService)
{

    private var uid: String = "anonymous"
    private lateinit var greeting: String;

    fun getUserName(): String {
        val user = userService.getUserForUID(uid) ?: throw IllegalArgumentException("No user with Uid $uid")

        greeting = if (userService.isAdmin(user)) {
            "Hello Admin"
        } else {
            "Hello Customer"
        }
        return greeting
    }

    fun showGreeting() : String = greeting

    fun showGreeting0() : String = greeting

    fun showGreeting111() : String = greeting + "111"

    fun showGreeting2() : String = runBlocking{
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
        return@runBlocking "World"
    }

}
