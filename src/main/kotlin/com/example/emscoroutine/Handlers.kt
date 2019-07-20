package com.example.emscoroutine

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Suppress("UNUSED_PARAMETER")
class UserHandler(
		private val repository: UserRepository
) {

	suspend fun listApi(request: ServerRequest) =ok().json().bodyAndAwait(repository.findAll())
	suspend fun counts(request: ServerRequest) =ok().json().bodyAndAwait(repository.count())
	suspend fun findOne(request: ServerRequest) =ok().json().bodyAndAwait(repository.findOne(request.pathVariable("id")))
	suspend fun insert(request: ServerRequest) =ok().json().bodyAndAwait(repository.insert(request.awaitBody<User>()))
	suspend fun update(request: ServerRequest) =ok().json().bodyAndAwait(repository.update(request.awaitBody<User>()))
	suspend fun deleteAll(request: ServerRequest) =ok().json().bodyAndAwait(repository.deleteAll())




}