package com.example.emscoroutine

import org.springframework.web.reactive.function.server.coRouter

fun routes(userHandler: UserHandler) =  coRouter {

	GET("/api/users", userHandler::listApi)
	GET("/api/counts", userHandler::counts)
	GET("/api/findOne/{id}", userHandler::findOne)
	POST("/api/insert", userHandler::insert)
	PUT("/api/update", userHandler::update)
	DELETE("/api/deleteAll", userHandler::deleteAll)

}