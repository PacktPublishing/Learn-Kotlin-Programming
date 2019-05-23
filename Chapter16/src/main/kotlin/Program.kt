package io.stepi

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.list
import kotlinx.serialization.protobuf.ProtoBuf


fun main() {
    val jsonData = Json.stringify(Student.serializer(), Student("Alexandra", "Smith", 85))
    println(jsonData)

    val jsonList = Json.stringify(Student.serializer().list, listOf(Student("Lisa", "Morreti", 67, 2)))
    println(jsonList)

    val jsonTree: JsonElement = Json().toJson(Student.serializer(), Student("Alexandra", "Smith", 85))
    println(jsonTree)

    // read back
    val obj = Json.parse(Student.serializer(), """{"firstName":"James","lastName":"Burke","score":79}""")
    println(obj)


    val proto = ProtoBuf().dump(Student.serializer(), Student("Alexandra", "Smith", 85))
    println(proto.joinToString("") { "%02x".format(it) })

    val studentProto: Student = ProtoBuf().load(Student.serializer(), proto)
    println(studentProto)


    val customer1Address = Address("260", "5th Ave", "New York", "10001", "USA")
    val customer1 = Customer("Alex", "Jones", customer1Address)
    println(Json.stringify(Customer.serializer(), customer1))


    val data1 = Json.parse(Data.serializer(), """{"a": "100500", "b": "10"}""")
    val data2 = Json.parse(Data.serializer(), """{"a": "100500"}""")
}