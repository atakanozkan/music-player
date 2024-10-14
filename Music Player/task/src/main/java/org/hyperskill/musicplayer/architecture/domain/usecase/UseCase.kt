package com.videochat.architecture.domain.usecase

interface UseCase<in INPUT, out OUTPUT> {
    suspend fun execute(input: INPUT): OUTPUT
}
