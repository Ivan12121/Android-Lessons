package com.example.androidlessons.students

class Students(_id: Int, _name: String, surname: String, clazz: Int, age: Int) {
    val id = _id
    val name = _name
    val gradesMath = mutableListOf<Int>()
    val gradesGeo = mutableListOf<Int>()
    val gradesRus = mutableListOf<Int>()


}