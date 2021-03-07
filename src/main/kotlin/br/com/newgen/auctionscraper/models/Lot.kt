package br.com.newgen.auctionscraper.models

import java.io.Serializable

data class Lot(
    val id: String,
    val rawValue: String,
    val description: String = "",
    val city: String = "",
    val date: String = "",
    val batch: String = ""
): Serializable