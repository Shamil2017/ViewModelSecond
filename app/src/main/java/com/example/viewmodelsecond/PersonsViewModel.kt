package com.example.viewmodelsecond

import androidx.lifecycle.ViewModel

class PersonsViewModel: ViewModel() {
    private  val persons = mutableListOf<Person>()
    fun addPerson(person:Person)
    {
        persons.add(person);
    }
    fun getPersons():List<Person> = persons
}