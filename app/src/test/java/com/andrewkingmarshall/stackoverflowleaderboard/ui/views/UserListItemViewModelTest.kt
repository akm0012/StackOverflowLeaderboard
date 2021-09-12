package com.andrewkingmarshall.stackoverflowleaderboard.ui.views

import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserListItemViewModelTest {

    @Mock
    var mockedUser = Mockito.mock(User::class.java)

    @Test
    fun `getName returns a the name`() {
        Mockito.`when`(mockedUser.displayName).thenReturn("Andrew Marshall")

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "Andrew Marshall"

        assertEquals(expected, viewModelInTest.getName())
    }

    @Test
    fun `getTotalReputation returns a String`() {
        Mockito.`when`(mockedUser.reputation).thenReturn(12345)

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "12345"

        assertEquals(expected, viewModelInTest.getTotalReputation())
    }

    @Test
    fun `getGoldMedalCount returns a String`() {
        Mockito.`when`(mockedUser.goldBadgeCount).thenReturn(12345)

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "12345"

        assertEquals(expected, viewModelInTest.getGoldMedalCount())
    }

    @Test
    fun `getSilverMedalCount returns a String`() {
        Mockito.`when`(mockedUser.silverBadgeCount).thenReturn(12345)

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "12345"

        assertEquals(expected, viewModelInTest.getSilverMedalCount())
    }

    @Test
    fun `getBronzeMedalCount returns a String`() {
        Mockito.`when`(mockedUser.bronzeBadgeCount).thenReturn(12345)

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "12345"

        assertEquals(expected, viewModelInTest.getBronzeMedalCount())
    }

    @Test
    fun `getProfilePicUrl returns a String`() {
        Mockito.`when`(mockedUser.profileImageUrl).thenReturn("ThePicUrl")

        val viewModelInTest = UserListItemViewModel(mockedUser)

        val expected = "ThePicUrl"

        assertEquals(expected, viewModelInTest.getProfilePicUrl())
    }


}