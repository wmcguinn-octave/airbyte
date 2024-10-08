/*
 * Copyright (c) 2024 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.cdk.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transformWhile

fun <T> Flow<T>.takeUntilInclusive(predicate: (T) -> Boolean): Flow<T> = transformWhile { value ->
    emit(value)
    !predicate(value)
}
