package com.irtiza.core.data.preferences

import android.content.SharedPreferences
import com.irtiza.core.domain.model.ActivityLevel
import com.irtiza.core.domain.model.Gender
import com.irtiza.core.domain.model.GoalType
import com.irtiza.core.domain.model.UserInfo
import com.irtiza.core.domain.preferences.Preferences
import androidx.core.content.edit
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_AGE
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_GENDER
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.irtiza.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
): Preferences{
    override fun saveGender(gender: Gender) {
        sharedPreferences.edit { putString(KEY_GENDER, gender.type) }
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit { putInt(KEY_AGE, age) }
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit { putInt(KEY_HEIGHT, height) }
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit { putFloat(KEY_WEIGHT, weight) }
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPreferences.edit { putString(KEY_ACTIVITY_LEVEL, activityLevel.level) }
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPreferences.edit { putString(KEY_GOAL_TYPE, goalType.type) }
    }

    override fun saveCarbRatio(carbRatio: Float) {
        sharedPreferences.edit { putFloat(KEY_CARB_RATIO, carbRatio) }
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        sharedPreferences.edit { putFloat(KEY_PROTEIN_RATIO, proteinRatio) }
    }

    override fun saveFatRatio(fatRatio: Float) {
        sharedPreferences.edit { putFloat(KEY_FAT_RATIO, fatRatio) }
    }

    override fun loadUserInfo(): UserInfo = sharedPreferences.run {
        val age = getInt(KEY_AGE,-1)
        val height = getInt(KEY_HEIGHT,-1)
        val weight = getFloat(KEY_WEIGHT,-1f)
        val carbRatio = getFloat(KEY_CARB_RATIO,-1f)
        val proteinRatio = getFloat(KEY_PROTEIN_RATIO,-1f)
        val fatRatio = getFloat(KEY_FAT_RATIO,-1f)
        val activityLevel = ActivityLevel.fromString(getString(KEY_ACTIVITY_LEVEL,null)?:"")
        val goalType = GoalType.fromString(getString(KEY_GOAL_TYPE,null)?:"")
        val gender =  Gender.fromString(getString(KEY_GENDER,null)?:"")

        UserInfo(gender= gender, age= age, height = height, weight = weight,
            activityLevel = activityLevel, goalType = goalType, carbRatio = carbRatio,
            proteinRatio = proteinRatio, fatRatio = fatRatio)
    }




}