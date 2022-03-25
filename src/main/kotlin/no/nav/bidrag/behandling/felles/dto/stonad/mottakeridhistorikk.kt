package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

interface MottakerIdHistorikkService {
  fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): StonadDto
}


data class MottakerIdHistorikkDto(

  @Schema(description = "stonad-id")
  val stonadId: Int = 0,

  @Schema(description = "Utgått Mottaker-Id")
  val mottakerIdEndretFra: String = "",

  @Schema(description = "Ny Mottaker-Id")
  val mottakerIdEndretTil: String = "",

  @Schema(description = "Saksbehandler/batchjobb/annet som har oppdatert mottaker-id")
  val opprettetAv: String = "",

  @Schema(description = "Opprettet timestamp")
  val opprettetTimestamp: LocalDateTime = LocalDateTime.now()
)

