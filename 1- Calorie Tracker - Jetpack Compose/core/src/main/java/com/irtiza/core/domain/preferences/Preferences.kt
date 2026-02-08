package com.irtiza.core.domain.preferences

import com.irtiza.core.domain.model.Gender

interface Preferences {
    fun saveGender(gender: Gender)
}