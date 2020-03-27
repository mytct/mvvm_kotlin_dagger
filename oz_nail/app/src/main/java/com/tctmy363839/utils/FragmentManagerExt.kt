package com.tctmy363839.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

internal fun FragmentManager.addFragment(containerId: Int, fragment: Fragment, tag: String){
    this.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .add(containerId, fragment, tag)
            .addToBackStack(tag)
            .show(fragment)
            .commit()
}

internal fun FragmentManager.replaceFragment(containerId: Int, fragment: Fragment, tag: String){
    this.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(containerId, fragment, tag)
            .addToBackStack(tag)
            .show(fragment)
            .commit()
}

internal fun FragmentManager.replaceFragmentNoBackStack(containerId: Int, fragment: Fragment, tag: String){
    this.beginTransaction()
            .disallowAddToBackStack()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(containerId, fragment, tag)
            .show(fragment)
            .commit()
}