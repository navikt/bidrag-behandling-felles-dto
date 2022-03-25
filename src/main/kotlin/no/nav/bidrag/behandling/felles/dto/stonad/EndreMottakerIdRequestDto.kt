package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description ="Request for å endre mottaker-id på en stønad")
data class EndreMottakerIdRequestDto(

  @Schema(description = "Stønad-id")
  val stonadId: Int,

  @Schema(description = "Ny Mottaker-id som skal erstatte eksisterende id")
  val nyMottakerId: String,

  @Schema(description = "opprettet_av")
  val opprettetAv: String
)