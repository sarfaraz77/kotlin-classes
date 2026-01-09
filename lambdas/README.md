# 🎃 Trick or Treat — Kotlin Lambdas & Function Types

This project helped me understand function types, lambdas, and higher-order functions in Kotlin using a simple “trick or treat” example.

# What it demonstrates

Functions can be stored in variables

Functions can be returned from other functions

Lambdas are just functions without names

Function types like (Int) -> String and () -> Unit

How behavior can be selected at runtime

# Core idea

trickOrTreat() does not perform an action — it returns a function (trick or treat) based on a Boolean flag.
The returned function is then executed later.

This separation between:

choosing behavior

running behavior

is the key to understanding lambdas and higher-order functions.

# Why this matters

This pattern is used everywhere in real Kotlin:

Button click handlers

Callbacks

Sorting, filtering, mapping

Android UI logic
