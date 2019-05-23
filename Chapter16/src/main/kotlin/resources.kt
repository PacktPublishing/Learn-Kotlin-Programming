package io.stepi

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Payment(
    @SerialName("mid")
    val merchantId: String,

    @SerialName("value")
    val amount: Double,

    @Optional
    val timestamp: Long = System.currentTimeMillis()
)


@Serializable
class Person(
    val name: String,
    @Transient val salary: Int = 42
) {
    @Transient
    var address = "House, Street, Postcode"
}

@Serializable
data class Address(
    val number: String,
    val street: String,
    val city: String,
    val zipCode: String,
    val country: String
)

@Serializable
class Customer(
    val firstName: String,
    val lastName: String,
    val address: Address
)


@Serializable
data class Data(val a: String) {
    @Optional
    val b: String = compute()

    private fun compute(): String {
        println("Initialize b value")
        return "42"
    }
}

@Serializable
data class Student(
    @SerialId(1) val firstName: String,
    @SerialId(2) val lastName: String,
    @SerialId(3) val score: Int,
    @SerialId(4) @Optional val penalties: Int = 0
)