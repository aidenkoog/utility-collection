package io.github.aidenkoog.android_utility.domain.model

interface RequestDataSource {
    data class SignIn(
        var userId: String?,
        var password: String?,
    )
}
