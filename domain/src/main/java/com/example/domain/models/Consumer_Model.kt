package com.example.domain.models

import java.io.Serializable

data  class Consumer_Model(
    var Login: String,
    var Password: String,
    var Name: String,
    var Surname: String,
    var Age: Int = 1
): Serializable