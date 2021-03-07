package br.com.newgen.auctionscraper.infrastructure.component

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import com.gargoylesoftware.htmlunit.WebClient
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HtmlUnitBean {

    @Bean
    fun webClient(): WebClient {
        turnOffLogs()

        val webClient = WebClient()
        webClient.options.isCssEnabled = false
        webClient.options.isJavaScriptEnabled = true
        webClient.waitForBackgroundJavaScript(99999)
        webClient.javaScriptTimeout = 99999

        return webClient;
    }

    private fun turnOffLogs() {
        val loggers = setOf("org.apache.http", "groovyx.net.http", "com.gargoylesoftware")

        for (log in loggers) {
            val logger: Logger = LoggerFactory.getLogger(log) as Logger
            logger.level = Level.INFO
            logger.isAdditive = false
        }
    }
}