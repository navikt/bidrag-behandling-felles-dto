package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema

@Schema
data class AlleMottakerIdHistorikkForStonadDto(

  @Schema(description = "Alle forekomster på mottaker-id-historikk for en stønad")
  val alleMottakerIdHistorikkForStonad: List<MottakerIdHistorikkDto>?
)