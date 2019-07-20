package com.example.emscoroutine

import de.flapdoodle.embed.mongo.distribution.Version
import org.springframework.fu.kofu.configuration
import org.springframework.fu.kofu.mongo.reactiveMongodb
import org.springframework.fu.kofu.webflux.webFlux

val dataConfig= configuration {
	beans {
		bean<UserRepository>()
	}
	reactiveMongodb{
		embedded{
			version= Version.Main.PRODUCTION
		}
	}
}

val webConfig = configuration {
	beans {
		bean<UserHandler>()
		bean(::routes)
	}
	webFlux {
		port = if (profiles.contains("test")) 8181 else 8080
		codecs {
			string()
			jackson()
		}
	}
}
